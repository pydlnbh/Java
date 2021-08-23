package com.design.pattern.db.proxy.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

    @Before("execution(void com.design.pattern.db.proxy.spring.v2.Tank.move())")
    void before() {
        System.out.println("before");
    }

    @After("execution(void com.design.pattern.db.proxy.spring.v2.Tank.move())")
    void after() {
        System.out.println("after");
    }
}
