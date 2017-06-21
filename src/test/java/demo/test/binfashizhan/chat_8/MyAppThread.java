package demo.test.binfashizhan.chat_8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class MyAppThread extends Thread {
    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();

    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable runnable) {
        this(runnable, DEFAULT_NAME);
    }

    public MyAppThread(Runnable runnable, String name) {
        super(runnable, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        log.log(Level.SEVERE, "UNCAUGHT in thread " + t.getName(), e);
                    }
                });
    }

    @Override
    public void run() {
        boolean debug = debugLifecycle;
        if (debug)log.log(Level.FINE, "Created " + getName());
        try {
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            if (debug)
                log.log(Level.FINE, "Exiting " + getName());
        }
    }
    public static int getThreadsCreated(){
        return created.get();
    }
    public static int getThreadAlive(){
        return alive.get();
    }

    public static boolean getDebug(){
        return debugLifecycle;
    }

    public static void setDebug(boolean b){
        debugLifecycle = b;
    }
}
