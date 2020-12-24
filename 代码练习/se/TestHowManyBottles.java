package com.java.se;

/**
 * @author PeiYiDing
 * @date 2020/12/23 22:50
 */
public class TestHowManyBottles {

    public static void main(String[] args) {

        int money = 20;
        int coca = 3;

        int drink = money / coca;
        int modules = money % coca;
        int drink2 = (modules + drink) / coca;
        int modules2 = (modules + drink) % coca;
        drink += drink2;
        drink += (modules2 + drink2) / coca;
        System.out.println(drink);
    }
}
