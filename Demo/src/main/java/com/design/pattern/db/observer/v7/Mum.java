package com.design.pattern.db.observer.v7;

public class Mum implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }

    private void hug() {
        System.out.println("mum hugging...");
    }
}
