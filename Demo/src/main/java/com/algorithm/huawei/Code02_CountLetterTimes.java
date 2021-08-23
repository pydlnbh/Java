package com.algorithm.huawei;

import java.util.Scanner;

/**
 * 计算某字母出现次数
 */
public class Code02_CountLetterTimes {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine().toLowerCase();
//        String s = sc.nextLine().toLowerCase();
//        System.out.print(str.length()-str.replaceAll(s,"").length());;
//        System.out.println(pra01());
//        pra02();
        pra03();
    }

    public static int pra01() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String s = sc.nextLine().toLowerCase();
        return str.length() - str.replaceAll(s, "").length();
    }

    public static void pra02() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String s = sc.nextLine().toLowerCase();
        System.out.println(str.length() - str.replaceAll(s, "").length());
    }

    public static void pra03() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String s = sc.nextLine().toLowerCase();
        int length = str.length() - str.replaceAll(s, "").length();
        System.out.println(length);
    }
}
