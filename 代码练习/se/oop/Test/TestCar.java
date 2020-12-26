package com.java.se.oop.Test;

import com.java.se.oop.entity.Car;
import com.java.se.oop.entity.Suv;
import com.java.se.oop.entity.Taxi;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class TestCar {

    public static void main(String[] args) {
        // car
        Car car = new Car();
        car.run();
        car.stop();
        System.out.println();

        // suv
        Suv xh = new Suv("xh");
        xh.run();
        xh.stop();
        System.out.println();

        // taxi
        Taxi taxi = new Taxi("yellow");
        taxi.run();
        taxi.stop();
    }
}
