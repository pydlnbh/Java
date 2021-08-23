package com.design.pattern.db.observer.v5;

public class Mum implements Observer {
    @Override
    public void actionOnWakeUp() {
        hug();
    }

    public void hug() {
        System.out.println("mum hugging...");
    }
}
