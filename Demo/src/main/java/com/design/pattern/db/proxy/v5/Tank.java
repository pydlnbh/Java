package com.design.pattern.db.proxy.v5;

import java.util.Random;

public class Tank implements MoveAble {
    @Override
    public void move() {
        System.out.println("Tank Moving ...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
