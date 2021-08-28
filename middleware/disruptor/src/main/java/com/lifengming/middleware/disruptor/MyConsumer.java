package com.lifengming.middleware.disruptor;

import com.lifengming.middleware.disruptor.common.BaseDisruptorConsumer;

import java.util.Calendar;

/**
 * @author mockuai
 */
public class MyConsumer extends BaseDisruptorConsumer<String> {
    private String name;

    public MyConsumer(String name) {
        this.name = name;
    }

    @Override
    public void consume(String data) {
        System.out.println(now() + this.name + "：拿到队列中的数据：" + data);
        //等待1秒钟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 获取当前时间（分:秒）
    public String now() {
        Calendar now = Calendar.getInstance();
        return "[" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND) + "] ";
    }
}
