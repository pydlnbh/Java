package com.java.se.thread.pool.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.thread.pool.ThreadPool
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        // 实例化
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 循环遍历
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }

        // 关闭
        executorService.shutdown();
    }
}
