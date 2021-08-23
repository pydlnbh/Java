package com.design.pattern.db.factorymethod;

public class PlaneFactory {
    public static MoveAble create() {
        return new Plane();
    }
}
