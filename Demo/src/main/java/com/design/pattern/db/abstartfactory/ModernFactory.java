package com.design.pattern.db.abstartfactory;

public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new AK();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
