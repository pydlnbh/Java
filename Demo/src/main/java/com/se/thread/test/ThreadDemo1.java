package com.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        // 实例化
        Run run = new Run();
        // 使用代理类
        Thread thread = new Thread(run);

        // 就绪状态
        thread.start();

        for (int i = 0; i < 10; i++) {
            // 打印线程执行状态
            System.out.println(Thread.currentThread().getName() + "----" + i);
            if (i == 3) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
