package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("name and age are " + name + ", " + age);
    }

    public static void main(String[] args) {
        Person person = new Person("zs", 23);
        person.display();
    }
}
