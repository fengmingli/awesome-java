package com.lifengming.client.proxys;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lifengming
 * @date 2021.01.04
 */
@Data
public class ProxyFactoryBean implements FactoryBean<Object> {
    private Class<?> type;
    private ProxyCreator proxyCreator;

    @Override
    public Object getObject() {
        return proxyCreator.createProxy(type);
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }
}
