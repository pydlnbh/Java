package com.se.loop;

/**
 * @author PeiYiDing
 * @date 2020/12/24 10:39
 */
public class TestArrayRecursive {

    public static void main(String[] args) {

        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int num) {

        if (num == 1 || num == 2) {
            return 1;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
