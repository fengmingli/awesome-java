package com.lifengming.client.proxys;

import com.lifengming.client.ApiServer;
import com.lifengming.client.handlers.WebClientRestHandler;
import com.lifengming.client.handlers.RestHandler;
import com.lifengming.client.beans.MethodInfo;
import com.lifengming.client.beans.ServerInfo;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

/**
 * @author lifengming
 * @date 2021.01.03
 */
public class JDKProxyCreator implements ProxyCreator {
    @Override
    public Object createProxy(Class<?> type) {
        ServerInfo serverInfo = extractServerInfo(type);
        //给每一个代理类一个实现
        RestHandler handler = new WebClientRestHandler();
        //初始化服务器信息
        handler.init(serverInfo);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{type}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //1、根据方法，与参数得到调用信息
                MethodInfo methodInfo = extractMethodInfo(method, args);
                return handler.invokeRest(methodInfo);
            }
        });
    }

    private MethodInfo extractMethodInfo(Method method, Object[] args) {
        MethodInfo methodInfo = new MethodInfo();
        this.extractUrlAndMethod(method, methodInfo);
        this.extractRequestParamAndBody(method, args, methodInfo);
        this.extractReturnInfo(method, methodInfo);
        return methodInfo;
    }

    /**
     *  提取返回值对象信息
     * @param method /
     * @param methodInfo /
     */
    private void extractReturnInfo(Method method, MethodInfo methodInfo) {
        boolean isFlux = method.getReturnType().isAssignableFrom(Flux.class);
        methodInfo.setReturnFlux(isFlux);
        Class<?> elementType = extractElementType(method.getGenericReturnType());
        methodInfo.setReturnElementType(elementType);
    }

    private Class<?> extractElementType(Type genericReturnType) {
        return (Class<?>) ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
    }


    private void extractRequestParamAndBody(Method method, Object[] args, MethodInfo methodInfo) {
        //得到请求参数或者body
        Parameter[] parameters = method.getParameters();
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        methodInfo.setParams(params);
        for (int i = 0; i < parameters.length; i++) {
            PathVariable pathVariable = parameters[i].getAnnotation(PathVariable.class);
            if (pathVariable != null) {
                params.put(pathVariable.value(), args[i]);
            }
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                methodInfo.setBody((Mono<?>) args[i]);
                //请求类型的实际类型
                methodInfo.setBodyElementType(extractElementType(parameters[i].getParameterizedType()));
            }
        }
    }

    private void extractUrlAndMethod(Method method, MethodInfo methodInfo) {
        //得到请求方法
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof GetMapping) {
                GetMapping getMapping = (GetMapping) annotation;
                methodInfo.setUrl(getMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.GET);
            } else if (annotation instanceof PostMapping) {
                PostMapping postMapping = (PostMapping) annotation;
                methodInfo.setUrl(postMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.POST);
            } else if (annotation instanceof DeleteMapping) {
                DeleteMapping deleteMapping = (DeleteMapping) annotation;
                methodInfo.setUrl(deleteMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.DELETE);
            } else if (annotation instanceof PutMapping) {
                PutMapping putMapping = (PutMapping) annotation;
                methodInfo.setUrl(putMapping.value()[0]);
                methodInfo.setMethod(HttpMethod.PUT);
            }
        }
    }

    /**
     * 获取服务器信息
     * @param type 类型
     * @return 服务器信息
     */
    private ServerInfo extractServerInfo(Class<?> type) {
        ServerInfo serverInfo = new ServerInfo();
        ApiServer apiServer = type.getAnnotation(ApiServer.class);
        serverInfo.setUrl(apiServer.value());
        return serverInfo;
    }
}

