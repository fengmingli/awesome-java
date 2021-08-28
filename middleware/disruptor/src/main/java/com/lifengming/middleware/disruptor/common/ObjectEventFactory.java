package com.lifengming.middleware.disruptor.common;

import com.lmax.disruptor.EventFactory;

/**
 * 事件生成工厂（用来初始化预分配事件对象）
 * @author mockuai
 */
public class ObjectEventFactory<T> implements EventFactory<ObjectEvent<T>> {
    public ObjectEventFactory() {
    }

    @Override
    public ObjectEvent<T> newInstance() {
        return new ObjectEvent<>();
    }
}
