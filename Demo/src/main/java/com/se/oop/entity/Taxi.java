package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Taxi extends Car {

    private String company;

    public Taxi() {

    }

    public Taxi(String company) {
        this.company = company;
    }

    public Taxi(String models, String license, String company) {
        super(models, license);
        this.company = company;
    }

    @Override
    public void run() {
        System.out.println(company + "Taxi Run...");
    }

    @Override
    public void stop() {
        System.out.println("Taxi stop...");
    }
}
