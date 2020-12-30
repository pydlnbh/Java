package com.java.se.thread.pc.pc3;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc3
 */
public class Producer implements Runnable {
    // 实例化
    Goods goods = new Goods();

    public Producer() {
    }

    public Producer(Goods goods) {
        this.goods = goods;
    }

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
