//package com.lifengming.consumer;
//
//import com.lifengming.client.TicketService;
//import org.apache.dubbo.config.annotation.Reference;
//import org.mockito.Mockito;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.util.HashMap;
//
//@Component
//public class MyBeanPostProcessor extends DependencyInjectionTestExecutionListener implements ApplicationContextAware, BeanPostProcessor {
//    String value = "userService,userService2,consumerApplicationTest";
//     HashMap<Class<?>,Object> test=new HashMap<>();
//
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (value.contains(beanName)) {
//            // 如果遇到需要替换的Bean，我们直接换成自己实现的Bean即可（这里可以把就得removeBeanDefinition，然后注册新的registerBeanDefinition）
//            // 这里的myConfig要继承自defaultConfig，否则引用的地方会报错
//            Object bean1 = applicationContext.getBean(beanName);
//            Field[] declaredFields = bean1.getClass().getDeclaredFields();
//            for (Field field : declaredFields) {
//                Reference annotation = field.getAnnotation(Reference.class);
//                if (annotation != null) {
////                    String name = field.getType().getName();
//                    if(test.get(field.getType())==null){
//                        Object mock = Mockito.mock(field.getType());
//                        test.put(field.getType(),mock);
//                    }
//                    Object mockObject = test.get(field.getType());
//                    try {
//                        field.setAccessible(true);
//                        field.set(bean, mockObject);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//
//        }
//        return bean;
//    }
//
//    @Override
//    protected void injectDependencies(TestContext testContext) throws Exception {
//        super.injectDependencies(testContext);
//        init(testContext);
//    }
//
//    private void init(final TestContext testContext) throws IllegalAccessException {
//        Object bean = testContext.getTestInstance();
//        Field[] fields = bean.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            Annotation[] annotations = field.getAnnotations();
//            for (Annotation annotation : annotations) {
//                if (annotation instanceof Reference) {
//                    if(test.get(field.getType())==null){
//                        Object mock = Mockito.mock(field.getType());
//                        test.put(field.getType(),mock);
//                    }
//                    Object mockObject = test.get(field.getType());
//                    field.setAccessible(true);
//                    field.set(bean, mockObject);
//                }
//            }
//
//        }
//    }
//}
