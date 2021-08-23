package com.algorithm.huawei.easy;

import java.util.Scanner;

/**
 * 字符串反转
 */
public class HJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] c = str.toCharArray();

        for (int i = c.length - 1; i >= 0; i--) {
           System.out.print(c[i]);
        }

        System.out.println();
    }
}
