package com.algorithm.huawei;

import java.util.Scanner;

/**
 * 十六进制转换十进制
 */
public class Code05_HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(Integer.valueOf(s.substring(2), 16).toString());
        }

        sc.close();
    }
}
