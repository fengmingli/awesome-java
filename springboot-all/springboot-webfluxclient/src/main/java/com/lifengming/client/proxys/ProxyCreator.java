package com.lifengming.client.proxys;

/**
 * 创建代理类接口
 * @author lifengming
 * @date 2021.01.03
 */
public interface ProxyCreator {

    /**
     * 创建代理类
     * @param clazz 类型
     * @return 目标对象
     */
    Object createProxy(Class<?> clazz);
}
