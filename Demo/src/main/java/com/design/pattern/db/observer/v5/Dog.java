package com.design.pattern.db.observer.v5;

public class Dog implements Observer {
    @Override
    public void actionOnWakeUp() {
        bark();
    }

    public void bark() {
        System.out.println("dog braking...");
    }
}
