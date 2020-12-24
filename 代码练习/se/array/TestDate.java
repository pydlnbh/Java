package com.java.se.array;

import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestDate {

    public static void main(String[] args) {

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a specify date (the blank space to separate): ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        System.out.print(year + "-" + month + "-" + day + " Total days are " + days(arr, year, month, day));
//        System.out.print(year + "" + month + "" + day);
//        System.out.println("Total days are " + days(arr, year, month, day));
    }

    public static int days(int[] arr, int year, int month, int day) {
        for (int i = 0; i < arr.length; i++) {
            if (((year % 4) == 0) && ((year % 100) != 0)) {
                if ((month - 1) == i) {
                    for (int j = 0; j <= i; j++) {
                        day += arr[j];
                    }
                    if (month >= 3) {
                        day += 1;
                    }
                }
            } else {
                if ((month - 1) == i) {
                    for (int k = 0; k <= i; k++) {
                        day += arr[k];
                    }
                }
            }
        }
        return day;
    }
}
