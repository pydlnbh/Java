package com.se.oop.Test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class HelloA {

    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I am A class");
    }

    static {
        System.out.println("static A");
    }
}

class HelloB extends HelloA {
    public HelloB() {
        System.out.println("Hello B");
    }

    {
        System.out.println("I am B class");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
