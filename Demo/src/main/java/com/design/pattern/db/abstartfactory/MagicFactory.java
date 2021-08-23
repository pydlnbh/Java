package com.design.pattern.db.abstartfactory;

public class MagicFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Apple();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
