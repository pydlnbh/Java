package com.design.pattern.db.observer.v5;

import com.design.pattern.db.observer.v4.Child;

/* 分离观察者和被观察者 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();
    }
}
