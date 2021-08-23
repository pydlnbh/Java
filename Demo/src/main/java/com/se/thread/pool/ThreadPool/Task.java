package com.se.thread.pool.ThreadPool;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.thread.pool.ThreadPool
 */
public class Task implements Runnable {
    @Override
    public void run() {
        // 睡眠
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印
        System.out.println(Thread.currentThread().getName() + "running");
    }
}
