package com.design.pattern.db.singleton;

/**
 * synchronized单独代码块写法提高效率, 但是会造成对象不一致
 * */
public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05() {

    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
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
            new Thread(() ->
                    System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }
}
