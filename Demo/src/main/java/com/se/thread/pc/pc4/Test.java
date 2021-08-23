package com.se.thread.pc.pc4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc4
 */
public class Test {
    public static void main(String[] args) {
        // 实例化阻塞队列数组
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        // 实例化制造者队列
        ProducerQueue producerQueue = new ProducerQueue(blockingQueue);
        // 实例化消费者队列
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);

        Thread thread = new Thread(producerQueue);
        Thread thread1 = new Thread(consumerQueue);

        thread.start();
        thread1.start();
    }
}
