package com.lifengming.github.AOP;

/**
 * @author lifengming
 * @date 2021.11.15
 */
public class AutoLog implements AutoCloseable {
    private final long start;

    public int handler(int sum) {
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
        return sum;
    }

    public AutoLog() {
        this.start = System.currentTimeMillis();
    }

    @Override
    public void close() throws Exception {
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }


}
