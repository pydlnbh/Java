package com.design.pattern.db.proxy.v4;

public class TankProxy implements MoveAble {
    Tank tank;

    public TankProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
       long start = System.currentTimeMillis();
       tank.move();
       long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
