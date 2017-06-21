package demo.test.binfashizhan;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class Java7pool {

    static class PrintTask extends RecursiveAction {

        private static final int THRESHOLD = 5;
        private int start;
        private int end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                System.out.println("come here!");
                for (int i = start; i < end; i++) {
                    System.out.println("start: " + start);
                    System.out.println("end: " + end);
                    System.out.println(Thread.currentThread().getName() + "的i 值");
                }
            } else {
                System.out.println("here it is!");
                int middle = (start + end) / 2;
                PrintTask left = new PrintTask(start, middle);
                PrintTask right = new PrintTask(middle, end);
                left.fork();
                right.fork();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(0, 10));

        //关闭线程池
        pool.shutdown();
        pool.awaitTermination(2, TimeUnit.SECONDS);
    }
}
