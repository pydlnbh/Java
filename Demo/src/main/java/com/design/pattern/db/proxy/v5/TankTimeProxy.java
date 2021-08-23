package com.design.pattern.db.proxy.v5;

public class TankTimeProxy implements MoveAble {
    MoveAble m;

    public TankTimeProxy(MoveAble move) {
        this.m = move;
    }
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
