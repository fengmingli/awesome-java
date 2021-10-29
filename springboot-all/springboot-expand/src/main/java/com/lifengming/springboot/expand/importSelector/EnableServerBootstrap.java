package com.lifengming.springboot.expand.importSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.stream.Stream;

/**
 * @author lifengming
 * @date 2020.12.06
 */
@Configuration
@EnableServer(type = Server.Type.HTTP)
public class EnableServerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注入当前引导类
        applicationContext.register(EnableServerBootstrap.class);

        //启动上下文
        applicationContext.refresh();

        Stream.of(applicationContext.getBeanDefinitionNames())
                .map(name -> "\t" + name)
                .forEach(System.out::println);

        //获取Server Bean对象，实际为HttpServer
        Server server = applicationContext.getBean(Server.class);
        server.start();

        server.stop();


    }
}
