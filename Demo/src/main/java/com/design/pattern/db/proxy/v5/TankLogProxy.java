package com.design.pattern.db.proxy.v5;

public class TankLogProxy implements MoveAble {
    MoveAble m;

    public TankLogProxy(MoveAble move) {
        this.m = move;
    }

    @Override
    public void move() {
        System.out.println("start moving ...");
        m.move();
        System.out.println("stopped!");
    }
}
