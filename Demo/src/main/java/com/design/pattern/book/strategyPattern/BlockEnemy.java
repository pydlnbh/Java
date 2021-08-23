package com.design.pattern.book.strategyPattern;

public class BlockEnemy implements IsStrategy{
    @Override
    public void operate() {
        System.out.println("第三个妙计！");
    }
}
