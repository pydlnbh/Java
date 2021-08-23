package com.algorithm.huawei.easy;

import java.util.Scanner;

/**
 * 斐波那契数列
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(getTotal(num));
        }
    }

    private static int getTotal(int month) {
        if (month < 3) {
            return 1;
        }

        return getTotal(month - 2) + getTotal(month - 1);
    }
}
