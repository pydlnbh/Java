package com.java.se;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 21:46
 */
public class TestDecimalBinaryConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a number: ");
        int number = scanner.nextInt();
        for (int i = 31; i >= 0; i--) {
            System.out.println((number & (1 << i)) == 0 ? "0" : 1);
        }
    }
}
