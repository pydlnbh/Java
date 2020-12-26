package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Suv extends Car {

    private String user;

    public Suv() {

    }

    public Suv(String user) {
        this.user = user;
    }

    public Suv(String models, String license, String user) {
        super(models, license);
        this.user = user;
    }

    @Override
    public void run() {
        System.out.println("I am " + user);
    }

    @Override
    public void stop() {
        System.out.println("Here I am");
    }
}
