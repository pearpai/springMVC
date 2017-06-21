package com.bq.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by heminghua on 16/9/27.
 */
@Component
@Aspect
public class AspectStyle {

    private final static Logger log = LogManager.getLogger(AspectStyle.class);

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.bq.service.TestService.*(..))")
    public void aspect(){	}

    /*
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("aspect before=======" + joinPoint);
    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        if(log.isInfoEnabled()){
            log.info("after " + joinPoint);
        }
    }

    //配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            if(log.isInfoEnabled()){
                log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            }
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            if(log.isInfoEnabled()){
                log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            }
        }
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        if(log.isInfoEnabled()){
            log.info("afterReturn " + joinPoint);
        }
    }

    //配置抛出异常后通知,使用在方法aspect()上注册的切入点
    @AfterThrowing(pointcut="aspect()", throwing="ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex){
        if(log.isInfoEnabled()){
            log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
        }
    }

    @AfterReturning(value = "@annotation(requestMappting)", argNames = "joinPoint, requestMappting")
    public void before(JoinPoint joinPoint, RequestMapping requestMappting){
        System.out.println("aspect before=======" + joinPoint);
    }
}
