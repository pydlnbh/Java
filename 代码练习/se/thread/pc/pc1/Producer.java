package com.java.se.thread.pc.pc1;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc
 */
public class Producer implements Runnable {
    // 定义变量
    private Goods goods;

    public Producer() {

    }

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                goods.setBrand("哇哈哈");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                goods.setProduct("矿泉水");
            } else {
                goods.setBrand("旺仔");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                goods.setProduct("小馒头");
            }

            // 打印
            System.out.println("生产者生产了" + this.goods.getBrand() + "--" + this.goods.getProduct());
        }
    }
}
