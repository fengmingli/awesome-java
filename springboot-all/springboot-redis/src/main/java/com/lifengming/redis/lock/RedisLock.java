package com.lifengming.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author lifengming
 * @since 2020.01.07
 */
@SuppressWarnings("all")
//@Component
public class RedisLock implements Lock {

    @Autowired
    private JedisPool jedisPool;

    private static final String KEY = "lock";
    private static final String OK = "OK";

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static AtomicBoolean isHappened = new AtomicBoolean(true);

    @Override
    public void lock() {
        //尝试加锁
        if (tryLock()) {
            //拿到了锁
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 尝试加锁
     **/
    @Override
    public boolean tryLock() {
        SetParams setParams = new SetParams();
        //2s
        setParams.ex(2);
        setParams.nx();
        String s = UUID.randomUUID().toString();
        Jedis resource = jedisPool.getResource();
        String lock = resource.set(KEY, s, setParams);
        resource.close();
        if (OK.equals(lock)) {
            //拿到了锁
            threadLocal.remove();
            threadLocal.set(s);
            if (isHappened.get()) {
                SingleThreadHolder.newThread(new MyRunnable(jedisPool)).start();
                isHappened.set(false);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }


    static class MyRunnable implements Runnable {

        private JedisPool jedisPool;

        MyRunnable(JedisPool jedisPool) {
            this.jedisPool = jedisPool;
        }

        @Override
        public void run() {
            Jedis jedis = jedisPool.getResource();
            while (true) {
                Long ttl = jedis.ttl(KEY);
                if (ttl != null && ttl > 0) {
                    jedis.expire(KEY, (int) (ttl + 1));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
