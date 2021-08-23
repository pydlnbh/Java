package com.design.pattern.db.prototype.v1;

public class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", "A-1");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
