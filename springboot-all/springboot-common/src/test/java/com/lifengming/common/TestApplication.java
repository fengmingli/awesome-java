package com.lifengming.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lifengming
 * @since 2020.01.02
 */
@SpringBootApplication
@ComponentScan({"com.lifengming.common.**"})
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
