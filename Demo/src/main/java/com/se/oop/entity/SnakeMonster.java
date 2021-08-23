package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class SnakeMonster extends Monster{

    private int hp;

    // extend methods
    public SnakeMonster() {
    }

    public SnakeMonster(String name, int hp, int power) {
        super(name, hp, power);
    }

    public void showHp() {
        if (hp < 10) {
            hp += 20;
        }
        System.out.println("hp is " + hp);
    }

    @Override
    public void attack() {
        System.out.println("Snake attack...");
    }

    @Override
    public void move() {
        System.out.println("S way...");
    }
}
