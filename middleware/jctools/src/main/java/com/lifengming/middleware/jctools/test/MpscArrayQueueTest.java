package com.lifengming.middleware.jctools.test;

import org.jctools.queues.MpscArrayQueue;

/**
 * @author mockuai
 */
public class MpscArrayQueueTest {

    public static final MpscArrayQueue<Object> MPSC_ARRAY_QUEUE = new MpscArrayQueue<>(16);

    public static void main(String[] args) {

        for (int i = 1; i <= 2; i++) {

            int index = i;

            new Thread(() -> MPSC_ARRAY_QUEUE.offer("dataddddddddddddddddddddddddddddddddddd" + index), "thread" + index).start();

        }

        try {
            Thread.sleep(1000L);
            // 入队操作，队列满则抛出异常
            MPSC_ARRAY_QUEUE.add("dataddddddddddddddddddddddddddddddddddd");

        } catch (Exception e) {

            e.printStackTrace();

        }

        System.out.println("队列大小：" + MPSC_ARRAY_QUEUE.size() + ", 队列容量：" + MPSC_ARRAY_QUEUE.capacity());

        // 出队操作，队列为空则抛出异常
        System.out.println("出队：" + MPSC_ARRAY_QUEUE.remove());

        // 出队操作，队列为空则返回 NULL
        System.out.println("出队：" + MPSC_ARRAY_QUEUE.poll());
    }

}
