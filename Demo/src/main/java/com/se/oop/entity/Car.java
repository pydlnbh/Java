package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Car {

    private String models;
    private String license;

    public Car() {
    }

    public Car(String models, String license) {
        this.models = models;
        this.license = license;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void run() {
        System.out.println("Run...");
    }

    public void stop() {
        System.out.println("stop...");
    }
}
