package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class AirConditioner {
    private String band;
    private int lmx;
    private int temperature;

    public void hot() {
        System.out.println("heating...");
    }

    public void cold() {
        System.out.println("cold...");
    }

    public void ventilate() {
        System.out.println("ventilate...");
    }
}
