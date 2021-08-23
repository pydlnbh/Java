package com.design.pattern.book.strategyPattern;

public class BackDoor implements IsStrategy{
    @Override
    public void operate() {
        System.out.println("第一个妙计！");
    }
}
