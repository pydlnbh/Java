package com.design.pattern.db.abstartfactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory modernFactory = new ModernFactory();

        Food food = modernFactory.createFood();
        food.name();
        Vehicle vehicle = modernFactory.createVehicle();
        vehicle.go();
        Weapon weapon = modernFactory.createWeapon();
        weapon.shoot();

        AbstractFactory magicFactory = new MagicFactory();

        magicFactory.createWeapon().shoot();
        magicFactory.createFood().name();
        magicFactory.createVehicle().go();
    }
}
