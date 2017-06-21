package demo.test.binfashizhan.chat_7;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class CheckForMail {

    public boolean checkMail(Set<String> hosts, long timeout, TimeUnit timeUnit) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final AtomicBoolean hasNewMail = new AtomicBoolean(false);

        try {
            for (final String host : hosts)
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        if (checkMail(host))
                            hasNewMail.set(true);
                    }
                });

        }finally {
            exec.shutdown();
            exec.awaitTermination(timeout, timeUnit);  // 阻塞等待
        }

        return hasNewMail.get();
    }

    private boolean checkMail(String host) {
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        CheckForMail checkForMail = new CheckForMail();
        Set<String> hosts = new HashSet<>();
        hosts.add("localhost");
        boolean checkMail = checkForMail.checkMail(hosts, 1, TimeUnit.SECONDS);
        System.out.println(checkMail);

    }

}
