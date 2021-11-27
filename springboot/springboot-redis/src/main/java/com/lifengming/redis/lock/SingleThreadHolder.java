package com.lifengming.redis.lock;

/**
 * @author lifengming
 * @since 2020.01.07
 */
public class SingleThreadHolder {
    public static Thread thread;

    public static Thread newThread(Runnable runnable){
        if (thread==null){
            synchronized (SingleThreadHolder.class){
                if(thread==null){
                    thread = new Thread(runnable);
                    thread.setDaemon(true);
                }
                return thread;
            }
        }
        return thread;
    }

}
