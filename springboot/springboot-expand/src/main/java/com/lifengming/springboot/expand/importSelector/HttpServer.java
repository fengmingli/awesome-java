package com.lifengming.springboot.expand.importSelector;

import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2020.12.06
 */
@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("Http 服务器启动中。。。");
    }

    @Override
    public void stop() {
        System.out.println("http服务器停止中。。。");
    }
}
