package com.design.pattern.db.proxy.v5;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        MoveAble tankTimeProxy = new TankTimeProxy(tank);
        MoveAble tankLogProxy = new TankLogProxy(tankTimeProxy);
        tankLogProxy.move();
    }
}
