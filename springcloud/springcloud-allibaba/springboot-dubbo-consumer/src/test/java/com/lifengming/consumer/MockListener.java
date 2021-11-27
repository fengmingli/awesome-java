//package com.lifengming.consumer;
//
//import org.apache.dubbo.config.annotation.Reference;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//
//import java.io.File;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//
///**
// * @author lifengming
// * @date 2020.11.07
// */
//public class MockListener extends DependencyInjectionTestExecutionListener {
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
//                    Object mock = Mockito.mock(field.getType());
//                    field.setAccessible(true);
//                    field.set(bean, mock);
//                }
//            }
//
//        }
//    }
//}
