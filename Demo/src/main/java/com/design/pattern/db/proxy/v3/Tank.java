package com.design.pattern.db.proxy.v3;

import java.util.Random;

public class Tank implements MoveAble {
    @Override
    public void move() {
        System.out.println("Tank moving ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
