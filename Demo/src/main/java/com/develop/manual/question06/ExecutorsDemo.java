package com.develop.manual.question06;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ExecutorsDemo {
    /**
     * 不允许使用Executors创建线程池
     */
    private static ExecutorService executor = Executors.newFixedThreadPool(15);

    /**
     * 使用guava提供的ThreadFactoryBuilder创建线程池执行器创建新线程时使用的工厂
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    /**
     * ThreadPoolExecutor创建线程池
     */
    private static ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // executor.execute(new SubThread()); // java.lang.OutOfMemoryError: GC overhead limit exceeded
            pool.execute(new SubThread());
        }
    }
}
