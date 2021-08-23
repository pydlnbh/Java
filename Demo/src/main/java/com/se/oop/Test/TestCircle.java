package com.se.oop.Test;

import com.se.oop.entity.Circle;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 * @Version: 1.0
 */
public class TestCircle {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        double area = circle.getArea();
        double perimeter = circle.getPerimeter();
        System.out.println("Area and perimeter are " + area + ", " + perimeter);
    }
}
