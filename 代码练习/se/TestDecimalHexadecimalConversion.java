package com.java.se;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 23:05
 */
public class TestDecimalHexadecimalConversion {

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a digit");
        float digit = scanner.nextFloat();*/

//        for (int i = 31; i >= 0; i++) {
//            System.out.println((digit & (float)(1 << i)) == 0 ? "0" : "1");
//        }

        boolean f = false;
        if (f == false) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

        for(int i = 1; i <= 10; i++) {
            if (i < 5) {
                continue;
            }
            System.out.println("总共有" + i + "次");
        }

    }
}
