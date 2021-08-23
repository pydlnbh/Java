package com.design.pattern.book.factoryMethodPattern;

public class BlackPeople implements Human{
    @Override
    public void laugh() {
        System.out.println("Black People Laugh!");
    }

    @Override
    public void cry() {
        System.out.println("Black People Cry!");
    }

    @Override
    public void talk() {
        System.out.println("Black People Talk!");
    }
}
