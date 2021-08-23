package com.design.pattern.db.singleton;

/**
 * 使用双重检查避免新建的实例不同, 同时增加线程效率
 * */
public class Mgr06 {

    private static Mgr06 INSTANCE;

    private Mgr06() {

    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                // 双重检查
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    // 业务方法
    public void m() {

    }

    // test
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }
}
