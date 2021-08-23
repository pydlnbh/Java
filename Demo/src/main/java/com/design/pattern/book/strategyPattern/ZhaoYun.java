package com.design.pattern.book.strategyPattern;

public class ZhaoYun {
    public static void main(String[] args) {
        Context context = new Context(new BackDoor());
        context.operate();
        System.out.println();

        Context context1 = new Context(new GiveGreenLight());
        context1.operate();
        System.out.println();

        Context context2 = new Context(new BlockEnemy());
        context2.operate();
    }
}
