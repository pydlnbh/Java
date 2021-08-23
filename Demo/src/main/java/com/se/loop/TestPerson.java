package com.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 16:06
 */
public class TestPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your name here: ");
        String name = sc.next();
        System.out.print("Please input your age here: ");
        int age = sc.nextInt();
        System.out.print("Please input your gender here: ");
        String gender = sc.next();
        System.out.println("The Computer recorded that:");
        System.out.print("your name is " + name + "\n");
        System.out.print("your age is " + age + "\n");
        System.out.print("your gender is " + gender + "\n");
    }
}
