package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Monster {

    // global variable
    private String name;
    private int hp;
    private int power;

    // global method
    public Monster() {
    }

    public Monster(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    // attack method
    public void attack() {
        System.out.println("attack...");
    }

    // move method
    public void move() {
        System.out.println("move...");
    }
}
