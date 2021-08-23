package com.design.pattern.db.singleton;

/**
 * 使用静态语句块写单例模式(饿汉式)
 * */
public class Mgr02 {

    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {

    }

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    // 业务方法
    public void m() {

    }

    // test
    public static void main(String[] args) {
        Mgr02 m1 = getInstance();
        Mgr02 m2 = getInstance();
        System.out.println(m1 == m2);
    }
}
