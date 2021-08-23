package com.design.pattern.db.observer.v7;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
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
