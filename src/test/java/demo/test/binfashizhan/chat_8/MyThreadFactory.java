package demo.test.binfashizhan.chat_8;

import java.util.concurrent.ThreadFactory;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName){
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, poolName);
    }
}
