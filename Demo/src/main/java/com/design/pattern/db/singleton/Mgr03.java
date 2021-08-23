package com.design.pattern.db.singleton;

/**
 * 懒汉式
 * lazy loading
 * 线程会冲突造成实例的对象不一致
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;

    private Mgr03() {

    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    // 业务方法
    public void m() {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
    }
}
