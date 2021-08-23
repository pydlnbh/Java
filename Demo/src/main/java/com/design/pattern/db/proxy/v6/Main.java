package com.design.pattern.db.proxy.v6;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();

        MoveAble o = (MoveAble) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{MoveAble.class},
                new LogHandler(tank));
        o.move();
    }
}
