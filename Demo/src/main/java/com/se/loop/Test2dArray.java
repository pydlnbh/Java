package com.se.loop;

/**
 * @author PeiYiDing
 * @date 2020/12/24 10:57
 */
public class Test2dArray {

    public static void main(String[] args) {

        twoDimensionalArray(3, 3);
    }

    public static void twoDimensionalArray(int a, int b) {

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
