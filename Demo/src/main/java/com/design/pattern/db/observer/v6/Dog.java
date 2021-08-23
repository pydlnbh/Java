package com.design.pattern.db.observer.v6;

public class Dog implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        bark();
    }

    private void bark() {
        System.out.println("dog barking...");
    }
}
