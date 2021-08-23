package com.design.pattern.db.observer.v9;

public class Test {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new MyActionListener());
        button.addActionListener(new MyActionListenerBak());
        button.buttonPressed();
    }
}
