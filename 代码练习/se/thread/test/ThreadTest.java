package com.java.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class ThreadTest implements Runnable{
    // 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-----" + i);
            try {
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // main
    public static void main(String[] args) throws InterruptedException {
        // 实例化
        ThreadTest threadTest = new ThreadTest();
        Thread thread = new Thread(threadTest);

        // 使线程进入就绪状态
        thread.start();

        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
            Thread.sleep(1000);
        }
    }
}
