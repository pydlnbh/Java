package com.java.se.loop;

/**
 * @author PeiYiDing
 * @date 2020/12/24 10:46
 */
public class TestNarcissisticNumber {

    public static void main(String[] args) {

        System.out.print("All of the narcissus numbers are ");
        System.out.print("{ ");
        for (int i = 100; i < 1000; i++) {
            int d0 = i % 10;
            int d1 = i / 10 % 10;
            int d2 = i / 100;
            if (((d0 * d0 * d0) +
                 (d1 * d1 * d1) +
                 (d2 * d2 * d2)) == i) {
                System.out.print(i + " ");
            }
        }
        System.out.print("}");
//            System.out.print(((d0 * d0 * d0) +
//                              (d1 * d1 * d1) +
//                              (d2 * d2 * d2)) == i ? i : "");
//            System.out.print(" ");
//        }
    }
}
