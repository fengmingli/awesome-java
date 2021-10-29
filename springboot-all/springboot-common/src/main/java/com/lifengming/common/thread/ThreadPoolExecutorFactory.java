package com.lifengming.common.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 使用单例模式，线程池
 *
 * @author lifengming
 * @since 2020.01.02
 */
@Slf4j
public class ThreadPoolExecutorFactory {
    private static volatile ThreadPoolExecutorFactory instance = null;
    private final ExecutorService executorService;

    private ThreadPoolExecutorFactory() {
        int availableProcessor = Runtime.getRuntime().availableProcessors();
        //核心线程
        int coreNum = availableProcessor / 2;
        // 用单例模式创建线程池，保留2个核心线程，最多线程为CPU个数的2n+1的两倍.
        int maxProcessor = (1 + availableProcessor * 2) * 2;
        log.info("本台服务器可用线程数：{}", maxProcessor);
        //设置线程的名字
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("task-pool-%d").build();
        executorService = new ThreadPoolExecutor(Math.min(coreNum, 2), maxProcessor,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), namedThreadFactory);
    }

    public static ThreadPoolExecutorFactory getInstance() {
        if (instance == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (instance == null) {
                    instance = new ThreadPoolExecutorFactory();
                }
            }
        }
        return instance;
    }

    /**
     * 执行任务
     * <p>
     *
     * @param command com
     */
    public void executeTask(Runnable command) {
        executorService.execute(command);
    }

}
