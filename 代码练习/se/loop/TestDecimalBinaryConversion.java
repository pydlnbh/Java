package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 21:46
 */
public class TestDecimalBinaryConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a number: ");
        int number1 = scanner.nextInt();
        int number2 = number1;
        String str = "";

        // The first way
        do {
            int divide = number1 / 2;
            int remainder = number1 % 2;
            str = remainder + str;
            number1 = divide;
        } while (number1 != 0);
        System.out.println(number1 + " convert to binary is " + str);

        // The second way
        System.out.print(number2 + " convert to binary is (32 bits) ");
        for (int i = 31; i >= 0; i--) {
            System.out.print((number2 & (1 << i)) == 0 ? "0" : 1);
        }
    }
}
