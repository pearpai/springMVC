package demo.test.binfashizhan.chat_5;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wuyunfeng on 2016/9/26.
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);

        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        TestHarness testHarness = new TestHarness();
        try {
            long x = testHarness.timeTasks(10, new Runnable() {
                @Override
                public void run() {
                    System.out.println(11111);
                }
            });
            System.out.println(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
