package com.design.pattern.db.proxy.spring.v1;

import java.util.Random;

public class Tank {
    void move() {
        System.out.println("Tank Moving ...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
