package com.lifengming.client.handlers;

import com.lifengming.client.beans.MethodInfo;
import com.lifengming.client.beans.ServerInfo;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author lifengming
 * @date 2021.01.03
 */
public class WebClientRestHandler implements RestHandler {

    private WebClient webClient;

    /**
     * 初始化webClient
     * @param serverInfo /
     */
    @Override
    public void init(ServerInfo serverInfo) {
        this.webClient = WebClient.create(serverInfo.getUrl());
    }

    /**
     * 处理rest请求
     * @param methodInfo /
     * @return
     */
    @Override
    public Object invokeRest(MethodInfo methodInfo) {
        Object result;
        WebClient.RequestBodySpec request = this.webClient
                //请求方法
                .method(methodInfo.getMethod())
                //请求url
                .uri(methodInfo.getUrl())
                //
                .accept(MediaType.APPLICATION_JSON);

        WebClient.ResponseSpec retrieve;

//        //判断是否为body请求
//        if (methodInfo.getBody() != null) {
//            retrieve = request.body(methodInfo.getBody(), methodInfo.getBodyElementType()).retrieve();
//        } else {
//            retrieve = request.retrieve();
//        }
//        retrieve.onStatus(status -> status.value() == 404, response -> Mono.just(new RuntimeException("Not Found Exception")));
//        //处理body
//        if (methodInfo.isReturnFlux()) {
//            result = retrieve.bodyToFlux(methodInfo.getReturnElementType());
//        } else {
//            result = retrieve.bodyToMono(methodInfo.getReturnElementType());
//        }
//        return result;
        return null;
    }
}
