package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 */
public class Actor extends Human {

    // global variable
    private String graduate;
    private String opus;

    public Actor() {
        System.out.println("I am a actor");
    }

    public Actor(String graduate, String opus) {
        this.graduate = graduate;
        this.opus = opus;
    }

    public Actor(String name, int age, String gender, String graduate, String opus) {
        super(name, age, gender);
        this.graduate = graduate;
        this.opus = opus;
    }

    @Override
    public void showMe() {
        super.showMe();
        System.out.println("I graduated from " + graduate);
        System.out.println("Best opus is + " + opus);
    }
    
}
