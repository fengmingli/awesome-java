package com.lifengming.github.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author lifengming
 * @date 2021.10.28
 */
public class Sync extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return compareAndSetState(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
