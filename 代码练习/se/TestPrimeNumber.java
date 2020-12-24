package com.java.se;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 19:38
 */
public class TestPrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        for (int i = 2; i < number; i++) {
            if ((number % i) == 0) {
                System.out.println(number + " is not a composite number");
                break;
            } else {
                System.out.println(number + " is a prime number");
                break;
            }
        }

    }

}
