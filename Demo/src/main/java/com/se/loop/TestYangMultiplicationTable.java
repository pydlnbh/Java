package com.se.loop;

/**
 * @author PeiYiDing
 * @date 2020/12/24 9:25
 */
public class TestYangMultiplicationTable {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j <= i) {
                    System.out.print(j + " * " + i + " = " + i * j + "\t");
                }
            }
            System.out.println();
        }
    }
}
