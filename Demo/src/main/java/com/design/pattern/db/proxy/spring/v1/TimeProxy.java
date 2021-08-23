package com.design.pattern.db.proxy.spring.v1;

public class TimeProxy {
    void before() {
        System.out.println("before");
    }

    void after() {
        System.out.println("after");
    }
}
