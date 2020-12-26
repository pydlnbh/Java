package com.java.se.oop.Test;

import com.java.se.oop.entity.Vehicle;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 * @Version: 1.0
 */
public class TestVehicle {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(20, 21);
        vehicle.move();
        vehicle.setSpeed(30);
        vehicle.speedUp(5);
        vehicle.speedDown(10);
    }
}
