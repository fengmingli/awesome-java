package com.lifengming.springboot.expand.importSelector;

/**
 * @author lifengming
 * @date 2020.12.06
 */
public interface Server {
    /**
     * 启动服务
     */
    void start();

    /**
     * 关闭服务
     */
    void stop();

    /**
     * 服务类型
     */
    enum Type {
        //HTTP 服务器
        HTTP,
        //FTP服务器
        FTP
    }

}
