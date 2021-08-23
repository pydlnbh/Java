package com.design.pattern.db.factorymethod;

public class CarFactory {
    public static MoveAble create() {
        return new Car();
    }
}
