package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 22:50
 */
public class TestHowManyBottles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input your much money: ");
        int money = scanner.nextInt();
        int price = 3;
        int bottle = 0;
        int sum = 0;
        int remainder = 0;

        while (money > price) {
            bottle = money / price;
            sum += bottle;
            remainder = money % price;
            money = remainder + bottle;
        }
        System.out.println("A total of " + sum + " bottles");

    }
}
