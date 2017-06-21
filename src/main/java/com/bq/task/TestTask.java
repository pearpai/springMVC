package com.bq.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by wuyunfeng on 2016/10/10.
 */
@Component("testTask")

public class TestTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void testTask(){
//        System.out.println("任务进行中。。。。。。" + getClass().getName());
    }


}
