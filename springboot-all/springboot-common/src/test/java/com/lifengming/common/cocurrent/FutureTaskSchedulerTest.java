package com.lifengming.common.cocurrent;


import org.junit.jupiter.api.Test;

/**
 * @author lifengming
 * @since 2019.12.17
 */
class FutureTaskSchedulerTest {

    @Test
    void add() {
        FutureTaskScheduler.add(() -> {
            System.out.println("测试成功！");
            System.out.println(Thread.currentThread().getName());
        });
    }
}