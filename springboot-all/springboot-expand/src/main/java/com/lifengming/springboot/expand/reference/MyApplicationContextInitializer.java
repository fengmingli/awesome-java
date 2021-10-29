package com.lifengming.springboot.expand.reference;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2020.06.04
 */
@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer<AbstractApplicationContext> {

    @Override
    public void initialize(AbstractApplicationContext applicationContext) {
        System.out.println("MyApplicationContextInitializer"+applicationContext);
    }
}
