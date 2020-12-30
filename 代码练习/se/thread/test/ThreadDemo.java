package com.java.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class ThreadDemo implements Runnable{
    // 重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }

    public static void main(String[] args) {
        // 获取当前线程对象
        Thread thread = Thread.currentThread();
        // 获取当前线程的名称
        System.out.println(thread.getName());
        // 获取线程的id
        System.out.println(thread.getId());
        // 获取线程的优先级, 0~10
        System.out.println(thread.getPriority());

        // 设置线程池的优先级
        thread.setPriority(8);
        System.out.println(thread.getPriority());

        // 实例化线程, 新生状态
        ThreadDemo threadDemo = new ThreadDemo();
        // 使用代理类
        Thread thread1 = new Thread(threadDemo);

        // 就绪状态
        thread1.start();

        // 判断线程是否存活
        System.out.println(thread1.isAlive());

        // main线程的执行代码
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }

        // 判断线程是否存活
        System.out.println(thread1.isAlive());
    }
}
