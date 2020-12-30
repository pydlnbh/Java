package com.java.se.thread.pc.pc4;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc4
 */
public class ProducerQueue implements Runnable {
    // 定义阻塞队列
    private BlockingQueue<Goods> blockingQueue;

    public ProducerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Goods goods = null;
            if (i % 2 == 0) {
                goods = new Goods("哇哈哈", "矿泉水");
            } else {
                goods = new Goods("旺旺", "小馒头");
            }

            // 打印
            System.out.println("生产者开始生产商品:" + goods.getBrand() + "---" + goods.getName());

            try {
                blockingQueue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
