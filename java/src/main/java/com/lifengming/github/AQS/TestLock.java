package com.lifengming.github.AQS;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lifengming
 * @date 2021.10.28
 */
public class TestLock {
    public static final int INTMAX = 10000;
    static int count = 0;
    static LeeLock leeLock = new LeeLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                leeLock.lock();
                for (int i = 0; i < INTMAX; i++) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                leeLock.unlock();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
    public void lock(){
        ReentrantLock lock = new ReentrantLock(true);
        try {
            lock.lock();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }


    }

}
