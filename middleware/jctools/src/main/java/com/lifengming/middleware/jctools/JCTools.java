package com.lifengming.middleware.jctools;

import org.jctools.queues.MpmcArrayQueue;
import org.jctools.queues.MpscArrayQueue;
import org.jctools.queues.MpscChunkedArrayQueue;
import org.jctools.queues.MpscUnboundedArrayQueue;
import org.jctools.queues.SpmcArrayQueue;
import org.jctools.queues.SpscArrayQueue;
import org.jctools.queues.SpscUnboundedArrayQueue;

import java.util.Queue;


/**
 * @author lifengming
 * @date 2021.08.22
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class JCTools {
    public static void main(String[] args) {
        // spsc-有界/无界队列
        Queue<String> spscArrayQueue = new SpscArrayQueue(16);
        Queue<String> spscUnboundedArrayQueue = new SpscUnboundedArrayQueue(2);
        // spmc-有界队列
        Queue<String> spmcArrayQueue = new SpmcArrayQueue<>(16);
        // mpsc-有界/无界队列
        Queue<String> mpscArrayQueue = new MpscArrayQueue<>(16);
        Queue<String> mpscChunkedArrayQueue = new MpscChunkedArrayQueue<>(1024, 8 * 1024);
        Queue<String> mpscUnboundedArrayQueue = new MpscUnboundedArrayQueue<>(2);
        // mpmc-有界队列
        Queue<String> mpmcArrayQueue = new MpmcArrayQueue<>(16);

    }
}
