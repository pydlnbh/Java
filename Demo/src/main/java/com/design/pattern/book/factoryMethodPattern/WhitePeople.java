package com.design.pattern.book.factoryMethodPattern;

public class WhitePeople implements Human{
    @Override
    public void laugh() {
        System.out.println("White People laugh!");
    }

    @Override
    public void cry() {
        System.out.println("White People Cry!");
    }

    @Override
    public void talk() {
        System.out.println("White People Talk!");
    }
}
