package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Cylinder extends Circle {

    private double hight;

    public Cylinder(int r, double hight) {
        super(r);
        this.hight = hight;
    }

    // calculating volume
    public double getVolume() {
        return super.getArea() * hight;
    }

    // show
    public void showVolume() {
        System.out.println("Cylinder is " + this.getVolume());
    }
}
