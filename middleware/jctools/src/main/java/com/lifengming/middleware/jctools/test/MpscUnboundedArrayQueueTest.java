package com.lifengming.middleware.jctools.test;

import org.jctools.queues.MpscUnboundedArrayQueue;
import org.jctools.util.Pow2;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lifengming
 * @date 2021.08.25
 */
public class MpscUnboundedArrayQueueTest {

    public static final Queue<String> MPSC_UNBOUNDED_ARRAY_QUEUE = new MpscUnboundedArrayQueue<>(16);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (; ; ) {
                System.out.println(MPSC_UNBOUNDED_ARRAY_QUEUE.poll());
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
        AtomicInteger atomicInteger = new AtomicInteger(1);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < Pow2.MAX_POW2; i++) {
                MPSC_UNBOUNDED_ARRAY_QUEUE.add(Thread.currentThread().getId() + "-1-" + atomicInteger.incrementAndGet());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < Pow2.MAX_POW2; i++) {
                MPSC_UNBOUNDED_ARRAY_QUEUE.add(Thread.currentThread().getId() + "-2-" + atomicInteger.incrementAndGet());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();


    }
}
