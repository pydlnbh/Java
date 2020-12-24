package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 22:01
 */
public class TestWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a letter: ");
        String str = scanner.next();
        char[] chars = str.toCharArray();
            if ('M' == chars[0] || 'm' == chars[0]) {
                System.out.println("Today is Monday");
            } else if ('T' == chars[0] || 't' == chars[0]) {
                if ('u' == chars[1] || 'u' == chars[0]) {
                    System.out.println("Today is Tuesday");
                } else if ('h' == chars[1] || 'H' == chars[0]) {
                    System.out.println("Today is Thursday");
                } else {
                    System.out.println("Input error, please input again");
                }
            } else if ('w' == chars[0] || 'W' == chars[0]) {
                System.out.println("Today is Wednesday");
            } else if ('f' == chars[0] || 'F' == chars[0]) {
                System.out.println("Today is Friday");
            } else if ('s' == chars[0] || 'S' == chars[0]) {
                if ('a' == chars[1] || 'A' == chars[1]) {
                    System.out.println("Today is Saturday");
                } else if ('u' == chars[1] || 'U' == chars[1]) {
                    System.out.println("Today is Sunday");
                }
            }
        }
}
