package com.design.pattern.db.observer.v7;

public class Dad implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }

    private void feed() {
        System.out.println("dad feeding...");
    }
}
