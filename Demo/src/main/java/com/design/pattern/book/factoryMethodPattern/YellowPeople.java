package com.design.pattern.book.factoryMethodPattern;

public class YellowPeople implements Human{
    @Override
    public void laugh() {
        System.out.println("Yellow People Laugh!");
    }

    @Override
    public void cry() {
        System.out.println("Yellow People Cry!");
    }

    @Override
    public void talk() {
        System.out.println("Yellow People Talk!");
    }
}
