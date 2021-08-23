package com.se.thread.pc.pc1;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc
 */
public class Consumer implements Runnable{
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
            if (i % 2 == 0) {
                // 设置品牌
                goods.setBrand("哇哈哈");

                // 睡眠
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 设置名字
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
            System.out.println("消费者消费了" + this.goods.getBrand() + "--" + this.goods.getProduct());
        }
    }
}
