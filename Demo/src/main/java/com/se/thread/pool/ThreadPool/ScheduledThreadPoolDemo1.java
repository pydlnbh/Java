package com.se.thread.pool.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.thread.pool.ThreadPool
 */
public class ScheduledThreadPoolDemo1 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println(System.currentTimeMillis());

        // 匿名内部类
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("1----延迟一秒执行, 每三秒执行一次");
                System.out.println(System.currentTimeMillis());
            }
        }, 1, 3, TimeUnit.SECONDS);

        // 关闭
        scheduledExecutorService.shutdown();
    }
}
