package com.lifengming.common.system;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 系统工具类，用于获取系统名称或者ip址址，mac地址等
 *
 * @author lifengming
 * @since 2019.12.31
 */
@Slf4j
public class SystemTools {

    private SystemTools() {
    }

    /**
     * 获取当前操作系统名称
     *
     * @return 操作系统名称 例如：windows xp,linux
     */
    public static String getOsName() {
        return System.getProperty("os.name").toLowerCase();
    }


    /**
     * 获取主机节点（服务器本地）的ip地址
     *
     * @return ip
     */
    public static String getIpAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("不能获取本地ip地址", e);
        }
        return "";
    }
}
