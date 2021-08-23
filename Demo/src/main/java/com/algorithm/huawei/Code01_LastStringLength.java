package com.algorithm.huawei;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 * */
public class Code01_LastStringLength {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        String[] s = str.split("\\s+");
//        int lastWordLength = s[s.length - 1].length();
//        System.out.println(lastWordLength);

//        System.out.println(pra01());
//        pra02();
        pra03();
    }

    public static int pra01() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split("\\s+");
        return s[s.length - 1].length();
    }

    public static void pra02() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split("\\s+");
        int length = s[s.length - 1].length();
        System.out.println(length);
    }

    public static void pra03() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split("\\s+");
        int length = s[s.length - 1].length();
        System.out.println(length);
    }
}
