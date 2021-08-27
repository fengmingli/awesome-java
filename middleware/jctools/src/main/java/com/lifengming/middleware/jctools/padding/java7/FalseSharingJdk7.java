package com.lifengming.middleware.jctools.padding.java7;


/**
 * @author mockuai
 */
public final class FalseSharingJdk7 implements Runnable {
    /**change*/
    public static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    private static PaddingL1[] longs;

    public FalseSharingJdk7(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        Thread.sleep(5000);
        System.out.println("starting....");
        if (args.length == 1) {
            NUM_THREADS = Integer.parseInt(args[0]);
        }

        longs = new PaddingL1[NUM_THREADS];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new PaddingL1();
        }
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
        System.out.println("duration = " + (System.nanoTime() - start) / 1000 / 1000 / 1000 + "s");
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharingJdk7(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }
}
