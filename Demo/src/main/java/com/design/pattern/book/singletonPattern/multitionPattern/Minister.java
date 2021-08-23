package com.design.pattern.book.singletonPattern.multitionPattern;

public class Minister {
    public static void main(String[] args) {
        Emperor instance = Emperor.getInstance();
        instance.emperorInfo();

        Emperor instance1 = Emperor.getInstance();
        instance1.emperorInfo();

        Emperor instance2 = Emperor.getInstance();
        instance2.emperorInfo();
    }
}
