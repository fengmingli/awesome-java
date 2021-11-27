package com.lifengming.springboot.expand.reference;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2020.06.04
 */
@Component
public class Listener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(" Listener");
    }
}
