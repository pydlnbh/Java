package com.design.pattern.db.observer.v2;

public class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void waveUp() {
        System.out.println("Waved Up! wuwuwuwu...");
        cry = true;
    }
}
