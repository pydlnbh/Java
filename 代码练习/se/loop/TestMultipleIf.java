package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 21:52
 */
public class TestMultipleIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input your score: ");
        int score = scanner.nextInt();
        if (score > 90 && score <= 100) {
            System.out.println("Reward a computer");
        } else if (score > 80) {
            System.out.println("Reward a Mobile");
        } else if (score > 60) {
            System.out.println("Reward a sumptuous meal");
        } else if (score < 60) {
            System.out.println("Reward a learning materials");
        } else {
            System.out.println("Input error, please input again");
        }
    }
}
