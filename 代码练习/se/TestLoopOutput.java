package com.java.se;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 22:22
 */
public class TestLoopOutput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a few numbers: ");
        int max = scanner.nextInt();
        int min = max;

        do {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            } else if (n > max) {
                max = n;
            } else if (n < min) {
                min = n;
            }
        } while (!scanner.equals(null));

        System.out.println("max is " + max + ", min is " + min);

    }
}
