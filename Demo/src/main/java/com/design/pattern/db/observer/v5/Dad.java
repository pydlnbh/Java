package com.design.pattern.db.observer.v5;

public class Dad implements Observer {
    @Override
    public void actionOnWakeUp() {
        feed();
    }

    public void feed() {
        System.out.println("dad feeding...");
    }
}
