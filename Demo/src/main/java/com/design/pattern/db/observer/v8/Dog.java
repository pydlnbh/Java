package com.design.pattern.db.observer.v8;

public class Dog implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        bark();
    }

    private void bark() {
        System.out.println("dog braking...");
    }
}
