package com.design.pattern.db.observer.v4;

import com.design.pattern.db.observer.v3.Dad;

public class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
        mum.hug();
        dog.bark();
    }
}
