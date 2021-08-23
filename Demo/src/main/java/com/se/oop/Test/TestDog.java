package com.se.oop.Test;

import com.se.oop.entity.Dog;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 * @Version: 1.0
 */
public class TestDog {

    public static void main(String[] args) {
        Dog dog = new Dog("husky", 2, true, "andy");
        System.out.print(dog);
        dog.run();
        dog.bark();
    }
}
