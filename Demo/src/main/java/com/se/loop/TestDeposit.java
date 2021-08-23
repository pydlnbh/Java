package com.se.loop;

/**
 * @author PeiYiDing
 * @date 2020/12/23 16:18
 */
public class TestDeposit {
    public static void main(String[] args) {
        int money = 10000;
        System.out.println("Principal is " + money);
        System.out.println("Regular principal a year total is " + Math.round(money + (money * 365 * 0.35)));
        System.out.println("Current principal a year total is " + Math.round(money + (money * 1.50 * 365)));
        System.out.println("Regular principal two year total is " + Math.round(money * 365 * 0.35 * 2));
        System.out.println("Current principal two year total is " + Math.round(money * 2.10 * 365 * 2));
    }
}
