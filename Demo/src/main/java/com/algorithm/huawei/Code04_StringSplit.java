package com.algorithm.huawei;

import java.util.Scanner;

/**
 * 字符串分割
 */
public class Code04_StringSplit {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//
//            while (str.length() > 8) {
//                String subStr = str.substring(0, 8);
//                System.out.println(subStr);
//                str = str.substring(8);
//            }
//
//            int tmp = 8 - str.length();
//
//            for (int i = 0; i < tmp; i++) {
//                str += "0";
//            }
//
//            System.out.println(str);
//        }
        pra01();
    }

    public static void pra01() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();

            while (str.length() > 8) {
                String subStr = str.substring(0, 8);
                System.out.println(subStr);
                str = str.substring(8);
            }

            int tmp = 8 - str.length();

            for (int i = 0; i < tmp; i++) {
                str += "0";
            }

            System.out.println(str);
        }
    }
}
