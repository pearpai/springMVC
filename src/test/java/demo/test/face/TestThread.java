package demo.test.face;

import demo.test.binfashizhan.chat_5.TestHarness;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class TestThread {

    private int j;
    public synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc: " + j );
    }

    public synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec: " + j );
    }

    static class Inc implements Runnable{
        private TestThread obj;

        public Inc(TestThread obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                this.obj.inc();
            }
        }
    }

    static class Dec implements Runnable{
        private TestThread obj;

        public Dec(TestThread obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                this.obj.dec();
            }
        }
    }


    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        for (int i = 0; i < 2; i++) {
            Thread inc = new Thread(new Inc(testThread));
            Thread dec = new Thread(new Dec(testThread));
            inc.start();
            dec.start();
        }
    }

}
