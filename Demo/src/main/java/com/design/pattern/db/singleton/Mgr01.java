package com.design.pattern.db.singleton;

/**
 * 饿汉式单例模式, 最常用的, 但是会有线程安全问题
 * */
public class Mgr01 {

   private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {

    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    // 业务方法
    public void m() {

    }

    // test
    public static void main(String[] args) {
        Mgr01 m1 = getInstance();
        Mgr01 m2 = getInstance();
        System.out.println(m1 == m2);
    }
}
