package com.design.pattern.db.state.v2;

public class MMHappyState extends MMState {
    @Override
    void smile() {
        System.out.println("MM Happy");
    }

    @Override
    void cry() {
        System.out.println("MM Crying");
    }

    @Override
    void say() {
        System.out.println("MM Saying");
    }
}
