package com.lifengming.spi.java;

public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime. one");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
