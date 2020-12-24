package com.java.se;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 19:19
 */
public class TestGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input your score: ");
        int score = scanner.nextInt();

        // if多分支
        if ((score >= 90) && (score <= 100)) {
            System.out.println("Your grade is A");
        } else if ((score >= 80) && (score <= 90)) {
            System.out.println("Your grade is B");
        } else if ((score >= 70) && (score <= 80)) {
            System.out.println("Your grade is C");
        } else if ((score >= 60) && (score <= 70)) {
            System.out.println("Your grade is D");
        } else if (score < 60) {
            System.out.println("Your grade is E");
        } else {
            System.out.println("Enter error, please enter again");
        }

        // switch多分枝
        switch (score / 10) {
            case 10:
                System.out.println("Your grade is A");
                break;
            case 9:
                System.out.println("Your grade is B");
                break;
            case 8:
                System.out.println("Your grade is C");
                break;
            case 7:
                System.out.println("Your grade is D");
                break;
            default:
                System.out.println("Your grade is E");
        }
    }
}
