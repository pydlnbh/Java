package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 19:30
 */
public class TestSeason {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the month: ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 2:
            case 3:
                System.out.println("Spring season");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Summer season");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Autumn season");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Winter season");
                break;
            default:
                System.out.println("Error, please enter again");
        }
    }
}
