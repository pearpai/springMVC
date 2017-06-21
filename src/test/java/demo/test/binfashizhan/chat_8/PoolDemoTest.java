package demo.test.binfashizhan.chat_8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class PoolDemoTest {

    private static final int THREAD_NUM = 100;

    private static ExecutorService batchPool;

    private final Semaphore semaphore = new Semaphore(THREAD_NUM);

    /**
     * 线程池 获取
     *
     * @return pool 线程池
     */
    static synchronized ExecutorService getBatchPool() {
        if (batchPool == null) {
            batchPool = Executors.newCachedThreadPool();
        } else if (batchPool.isShutdown()) {
            batchPool = Executors.newCachedThreadPool();
        }
        return batchPool;
    }

    public void execTask(final Runnable task) throws InterruptedException {
        semaphore.acquire();
        try {
            batchPool.execute(() -> {
                try {
                    task.run();
                }finally {
                    semaphore.release();
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }

}
