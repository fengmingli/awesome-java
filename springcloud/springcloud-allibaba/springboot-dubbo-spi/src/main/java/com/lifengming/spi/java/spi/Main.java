package com.lifengming.spi.java.spi;

import com.lifengming.spi.java.Robot;
import com.lifengming.spi.java.SpiConsumer;

import java.util.Iterator;
import java.util.List;

/**
 * @author lifengming
 * @date 2021.01.23
 */
public class Main {
    public static void main(String[] args) {
        List<Robot> robots = SpiBootstrap.loadAllOrdered(Robot.class);

        robots.forEach(Robot::sayHello);
    }
}
