package com.java.se.thread.pc.pc2;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc2
 */
public class Producer implements Runnable {
    // 引入货物类
    Goods goods = new Goods();

    // 生产者构造方法
    public Producer(Goods goods) {
        this.goods = goods;
    }

    // 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                goods.set("哇哈哈", "矿泉水");
            } else {
                goods.set("旺仔", "小馒头");
            }
        }
    }
}
