package com.design.pattern.book.strategyPattern;

public class GiveGreenLight implements IsStrategy{
    @Override
    public void operate() {
        System.out.println("第二个妙计！");
    }
}
