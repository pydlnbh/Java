package com.algorithm.huawei;

import java.util.Scanner;

/**
 * 小数四舍五入
 */
public class Code07_Round {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double d = sc.nextDouble();
//        int i = (int) d;
//
//        if (d < 0) {
//            return;
//        } else if ((d - i) >= 0.5) {
//            i++;
//        }
//        System.out.println(i);
        pra01();
    }

    public static void pra01() {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        System.out.println(Math.round(d));
    }
}
