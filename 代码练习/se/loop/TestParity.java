package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 19:12
 */
public class TestParity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        long number = scanner.nextLong();
        if ((number % 2) == 0) {
            System.out.println(number + " is a even number");
        } else {
            System.out.println(number + " is a odd number");
        }
    }
}
