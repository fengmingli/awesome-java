package com.lifengming.github.AQS;

/**
 * @author lifengming
 * @date 2021.10.28
 */
public class LeeLock {

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}
