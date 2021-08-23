package com.design.pattern.db.proxy.v2;

import java.util.Random;

public class Tank implements MoveAble {
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving ...");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
