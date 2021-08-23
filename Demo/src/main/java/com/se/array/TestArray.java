package com.se.array;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/24 13:46
 */
public class TestArray {

    public static void main(String[] args) {

        String[] strings = {"Java", "Ruby", "Python", "Vue", "PHP", "Go", "C++", "JavaScript", "Perl", "C#"};

        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a word: ");
        String str = sc.next();
        boolean flag = false;

        for (int i = 0; i < strings.length; i++) {
            if (str.equals(strings[i])) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("no");
        }
    }
}
