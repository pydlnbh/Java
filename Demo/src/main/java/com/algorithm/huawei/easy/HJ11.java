package com.algorithm.huawei.easy;

import java.util.Scanner;

/**
 * 数字颠倒
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String str = Integer.toString(num);
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb);
    }
}
