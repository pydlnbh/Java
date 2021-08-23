package com.se.thread.pc.pc2;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc2
 */
public class Consumer implements Runnable {
    // 实例化
    Goods goods = new Goods();

    public Consumer() {

    }

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            goods.get();
        }
    }
}
