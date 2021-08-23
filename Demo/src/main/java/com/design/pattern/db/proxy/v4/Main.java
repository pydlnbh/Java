package com.design.pattern.db.proxy.v4;

public class Main {
    public static void main(String[] args) {
        new TankProxy(new Tank()).move();
    }
}
