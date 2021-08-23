package com.design.pattern.book.singletonPattern;

public class Emperor {
    private static Emperor emperor = null;

    public Emperor() {

    }

    public static Emperor getInstance() {
        if (emperor == null) {
            emperor = new Emperor();
        }
        return emperor;
    }

    public void emperorInfo(){
        System.out.println("I am a emperor!");
    }
}
