package com.design.pattern.db.singleton;

/**
 * 懒汉式
 * lazy loading
 * 加上synchronized是新建的是同一个实例, 但是效率会下降
 */
public class Mgr04 {

    private static volatile Mgr04 INSTANCE; //JIT

    private Mgr04() {

    }

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    // test
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Mgr04.getInstance().hashCode())
            ).start();
        }
    }
}
