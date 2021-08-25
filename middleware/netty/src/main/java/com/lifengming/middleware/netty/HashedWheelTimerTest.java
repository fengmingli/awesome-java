package com.lifengming.middleware.netty;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * 简单的几行代码，基本展示了 HashedWheelTimer 的大部分用法。
 * 示例中我们通过 newTimeout() 启动了三个 TimerTask，timeout1 由于被取消了，所以并没有执行。
 * timeout2 和 timeout3 分别应该在 1s 和 3s 后执行。
 * 然而从结果输出看并不是，timeout2 和 timeout3 的打印时间相差了 5s，这是由于 timeout2 阻塞了 5s 造成的。
 *
 * 由此可以看出，时间轮中的任务执行是串行的，当一个任务执行的时间过长，会影响后续任务的调度和执行，很可能产生任务堆积的情况。
 *
 * @author lifengming
 * @date 2021.08.25
 */
public class HashedWheelTimerTest {

    public static void main(String[] args) {

        Timer timer = new HashedWheelTimer();

        Timeout timeout1 = timer.newTimeout(timeout -> System.out.println("timeout1: " + new Date()), 10, TimeUnit.SECONDS);

        if (!timeout1.isExpired()) {

            timeout1.cancel();

        }

        timer.newTimeout(timeout -> {
            System.out.println("timeout2: " + new Date());

            Thread.sleep(5000);

        }, 1, TimeUnit.SECONDS);

        timer.newTimeout(timeout -> System.out.println("timeout3: " + new Date()), 3, TimeUnit.SECONDS);

    }
}
