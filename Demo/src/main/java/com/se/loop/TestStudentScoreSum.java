package com.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 21:37
 */
public class TestStudentScoreSum {
    public static void main(String[] args) {
        int[] score = new int[5];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input five Students score:");
        for (int i = 0; i < 5; i++) {
            score[i] = scanner.nextInt();
            sum += score[i];
        }
        System.out.println("Score sum are " + sum);
    }
}
