package com.java.se.oop.Test;

import com.java.se.oop.entity.AirConditioner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 * @Version: 1.0
 */
public class TestAirConditioner {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.hot();
        airConditioner.cold();
        airConditioner.ventilate();
    }
}
