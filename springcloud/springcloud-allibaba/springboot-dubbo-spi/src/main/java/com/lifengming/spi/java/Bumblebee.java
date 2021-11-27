package com.lifengming.spi.java;

public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee. 0");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
