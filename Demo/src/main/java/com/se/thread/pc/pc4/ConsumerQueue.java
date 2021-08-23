package com.se.thread.pc.pc4;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc4
 */
public class ConsumerQueue implements Runnable {
    // 定义阻塞队列
    private BlockingQueue<Goods> blockingQueue;

    public ConsumerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Goods goods = blockingQueue.take();
                System.out.println("消费者消费的商品" + goods.getBrand() + "---" + goods.getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
