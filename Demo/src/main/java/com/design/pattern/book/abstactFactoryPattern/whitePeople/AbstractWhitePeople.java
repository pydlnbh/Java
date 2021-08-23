package com.design.pattern.book.abstactFactoryPattern.whitePeople;

import com.design.pattern.book.abstactFactoryPattern.Human;

public abstract class AbstractWhitePeople implements Human {
    @Override
    public void laugh() {
        System.out.println("White People Laugh!");
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
