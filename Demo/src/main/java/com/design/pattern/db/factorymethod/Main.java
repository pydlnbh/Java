package com.design.pattern.db.factorymethod;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();

        MoveAble m = CarFactory.create();
        m.go();

        m = BroomFactory.create();
        m.go();

        m = PlaneFactory.create();
        m.go();
    }
}
