package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class Vehicle {

    private int speed;
    public int size;

    public Vehicle() {

    }

    public Vehicle(int speed, int size) {
        this.speed = speed;
        this.size = size;
    }

    public void move() {
        System.out.println("Move");
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void speedUp(int speed) {
        System.out.println(this.speed + speed);
    }

    public void speedDown(int speed) {
        System.out.println(this.speed - speed);
    }
}
