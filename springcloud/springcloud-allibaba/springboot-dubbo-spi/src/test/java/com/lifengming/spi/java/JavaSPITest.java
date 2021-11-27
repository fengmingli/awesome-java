package com.lifengming.spi.java;


import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author lifengming
 * @date 2020.04.07
 */
public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

}