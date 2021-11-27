package com.lifengming.github.AOP;

/**
 * @author lifengming
 * @date 2021.11.15
 */
public class Test {
    public static void main(String[] args) throws Exception {

        try ( AutoLog log = new AutoLog()){
            System.out.println(log.handler(1)); 
        }


    }
}
