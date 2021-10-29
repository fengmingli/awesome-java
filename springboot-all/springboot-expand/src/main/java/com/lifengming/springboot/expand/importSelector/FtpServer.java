package com.lifengming.springboot.expand.importSelector;

import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2020.12.06
 */
@Component
public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("Ftp服务开始。。。");
    }

    @Override
    public void stop() {
        System.out.println("Ftp服务器停止中。。。");
    }
}
