package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 * @Version: 1.0
 */
public class Dog {

    private String breed;
    private int age;
    private boolean flag;
    private String name;

    public Dog() {
        flag = true;
    }

    public Dog(String breed, int age, boolean flag, String name) {
        this.breed = breed;
        this.age = age;
        this.flag = flag;
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void bark() {
        if (flag) {
            System.out.println("bark...");
        } else {
            System.out.println("stay...");
        }
    }

    public void run() {
        if (flag) {
            System.out.println("Run...");
        } else {
            System.out.println("stay...");
        }
    }

    @Override
    public String toString() {
        return "名字叫" + name + "的" + breed + (flag ? "心情很好" : "心情不好");
    }
}
