package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class CenMonster extends Monster {

    // extend methods
    public CenMonster() {
    }

    public CenMonster(String name, int hp, int power) {
        super(name, hp, power);
    }

    @Override
    public void attack() {
        System.out.println("attack...");
    }

    @Override
    public void move() {
        System.out.println("fly...");
    }
}
