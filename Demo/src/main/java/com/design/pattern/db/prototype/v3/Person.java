package com.design.pattern.db.prototype.v3;

public class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location(new StringBuffer("bj"), 22);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }
}
