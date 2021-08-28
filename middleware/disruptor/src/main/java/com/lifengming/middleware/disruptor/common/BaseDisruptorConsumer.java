package com.lifengming.middleware.disruptor.common;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * 消费者抽象类
 * @author mockuai
 */
public abstract class BaseDisruptorConsumer<T>
        implements EventHandler<ObjectEvent<T>>, WorkHandler<ObjectEvent<T>> {
    public BaseDisruptorConsumer() {
    }

    @Override
    public void onEvent(ObjectEvent<T> event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    @Override
    public void onEvent(ObjectEvent<T> event) throws Exception {
        this.consume(event.getObj());
    }

    /**
     * 消费
     * @param var1 消费的对象
     */
    public abstract void consume(T var1);
}
