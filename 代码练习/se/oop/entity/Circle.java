package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class Circle {
    // radius
    private int r;

    public Circle() {

    }

    public Circle(int r) {
        this.r = r;
    }

    // calculating perimeter
    public double getPerimeter() {
        // calculating perimeter
        return 2 * r * Math.PI;
    }

    // calculating area
    public double getArea() {
        return r * r * Math.PI;
    }

    // show
    public void show() {
        System.out.println("Perimeter is " + getPerimeter() + ", Area is " + getArea());
    }
}
