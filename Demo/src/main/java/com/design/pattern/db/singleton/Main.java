package com.design.pattern.db.singleton;

public class Main {

    public static void main(String[] args) {

        // Mgr01 ~ Mgr08 都实例化不了, 需要调用getInstance()方法来实例化对象
        Mgr01.getInstance();
        // ~
        Mgr08.getInstance();
    }
}
