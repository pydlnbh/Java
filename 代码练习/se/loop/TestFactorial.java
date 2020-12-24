package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/24 11:05
 */
public class TestFactorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a digit: ");
        int num = sc.nextInt();
        System.out.println(num + "! factorial is " + factorial(num));
        System.out.println(num + "! factorial is " + factorialRecursion(num));
    }

    public static int factorial(int num) {

        int ans = 1;
        for (int i = 1; i <= num; i++) {
            ans = ans * i;
        }
        return ans;
    }

    public static int factorialRecursion(int num) {
        if (num == 1) {
            return 1;
        }
        return factorialRecursion(num - 1) * num;
    }
}
