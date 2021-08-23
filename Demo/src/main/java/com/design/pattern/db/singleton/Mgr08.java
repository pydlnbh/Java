package com.design.pattern.db.singleton;

/**
 * 枚举类实现单例模式
 * */
public enum Mgr08 {

    INSTANCE;

    public static Mgr08 getInstance() {
        return INSTANCE;
    }

    // 业务方法
    public void m() {

    }

    // test
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr08.INSTANCE.hashCode())).start();
        }
    }
}
