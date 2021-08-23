package com.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 17:59
 */
public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println(num + ", sqrt is " + Math.sqrt(num));

        System.out.println(uTest(100));
        int i = 99;
        operate(i);
        System.out.println(i + 100);
    }

    public static float uTest(int num) {
        int sum = num + 100;
        return sum;
    }

    static void operate(int i) {
        i += 100;
    }
}
