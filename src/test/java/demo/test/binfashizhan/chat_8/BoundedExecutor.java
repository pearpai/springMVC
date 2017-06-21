package demo.test.binfashizhan.chat_8;

import java.util.concurrent.*;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class BoundedExecutor {

    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, int bound) {
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }


    public static void main(String[] args) {
        ExecutorService batchPool;
        batchPool = Executors.newCachedThreadPool();
        BoundedExecutor boundedExecutor = new BoundedExecutor(batchPool, 9);

        for (int i = 0; i < 10000; i++) {
            Runnable task = () -> {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"=====" + System.nanoTime());
            };
            try {
                boundedExecutor.submitTask(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
