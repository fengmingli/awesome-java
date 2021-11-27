package com.lifengming.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lifengming
 * @since 2020.01.31
 */
@SpringBootApplication
public class ConsumerApplicationWebTest {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationWebTest.class, args);
        System.out.println("==========启动成功================");
    }
}
