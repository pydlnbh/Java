package com.design.pattern.db.proxy.v7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeProxy implements InvocationHandler {
    MoveAble moveAble;

    public TimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    void before() {
        System.out.println("before");
    }

    void after() {
        System.out.println("after");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(moveAble, args);
        after();
        return o;
    }
}
