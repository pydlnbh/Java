package com.design.pattern.db.observer.v8;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        // hook callback function
        observers.add((e) -> {
            System.out.println("test");
        });
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed", this);

        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }
    }
}
