package com.java.se;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 16:10
 */
public class TestCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input radius of a circle: ");
        float r = sc.nextFloat();
        System.out.println("Perimeter is " + r * 2 * Math.PI);
        System.out.println("Area is " + r * r * Math.PI);
    }
}
