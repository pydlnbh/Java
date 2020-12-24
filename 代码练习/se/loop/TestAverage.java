package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/24 10:21
 */
public class TestAverage {

    public static void main(String[] args) {

        int sum = 0;
        int[] average = new int[3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input three classes of grade: ");

        for (int c = 0; c < 3; c++) {
            for (int i = 0; i < 10; i++) {
                int score = scanner.nextInt();
                sum += score;
            }
            average[c] = sum / 10;
            System.out.println("Average score is " + average[c]);
            sum = 0;
        }
    }
}
