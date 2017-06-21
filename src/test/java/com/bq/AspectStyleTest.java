package com.bq;

import com.bq.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heminghua on 16/9/28.
 */
public class AspectStyleTest {

    public static void main(String[] args) {
        //启动Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        //获取service组件
        TestService service = (TestService) context.getBean("testService");
        //以普通的方式调用TestService对象的方法
        service.aspectService();
        System.out.println("Delete user : ");
    }
}
