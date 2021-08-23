package com.design.pattern.db.factorymethod;

public class BroomFactory {
    public static MoveAble create() {
        return new Broom();
    }
}
