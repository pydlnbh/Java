package com.design.pattern.db.proxy.v7;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        MoveAble o = (MoveAble) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{MoveAble.class},
                new TimeProxy(tank));

        o.move();
    }
}
