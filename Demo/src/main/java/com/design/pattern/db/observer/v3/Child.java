package com.design.pattern.db.observer.v3;

public class Child {

    private boolean cry = false;
    private Dad dad = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void waveUp() {
        cry = true;
        dad.feed();
    }
}
