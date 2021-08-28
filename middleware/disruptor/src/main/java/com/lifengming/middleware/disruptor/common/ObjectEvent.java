package com.lifengming.middleware.disruptor.common;

/**
 * 事件对象
 * @author mockuai
 */
public class ObjectEvent<T> {
    private T obj;

    public ObjectEvent() {
    }

    public T getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
