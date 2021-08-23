package com.algorithm.practice.day01;

public class Test {
    public static void main(String[] args) {
        // [0, 1) 0 ~ 0.999999999999
        System.out.println(Math.random());

        // [0, 1) 0
        System.out.println((int) Math.random());

        // [0, 10) 0 ~ 9;
        System.out.println((int) (10 * Math.random()));

        // [0, 11) 0 ~ 10
        System.out.println((int) (11 * Math.random()));

        // [0, 10) + [0
        System.out.println((int) ((10 + 1) * Math.random()));
    }
}
