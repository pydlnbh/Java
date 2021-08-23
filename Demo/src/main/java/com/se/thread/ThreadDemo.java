package com.se.thread;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread
 */
public class ThreadDemo extends Thread {
    // 实现多线程必须重写run方法
    @Override
    public void run() {
        // 设置一个线程运行
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-------" + i);
        }
    }

    // main
    public static void main(String[] args) {
        // 必须实例化
        ThreadDemo threadDemo = new ThreadDemo();

        // 线程在启动的时候, 通过start()调用, 而不是run()方法调用
        threadDemo.start();

        // 在设置一个主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---------" + i);
        }
    }
}
