package com.java.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Sportsman extends Human {

    // global variables
    private String event;
    private String result;

    public Sportsman() {
        System.out.println("I am a ordinary people");
    }

    public Sportsman(String event, String result) {
        this.event = event;
        this.result = result;
    }

    public Sportsman(String name, int age, String gender, String event) {
        super(name, age, gender);
        this.event = event;
    }

    public Sportsman(String name, int age, String gender, String event, String result) {
        super(name, age, gender);
        this.event = event;
        this.result = result;
    }

    @Override
    public void showMe() {
        super.showMe();
        System.out.println("I good at " + event);
        System.out.println("Best result is " + result);
    }
}
