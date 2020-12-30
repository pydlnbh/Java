package com.java.se.thread.pc.pc3;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc3
 */
public class Goods {
    // 定义变量
    private String brand;
    private String name;
    // 默认不存在商品, 如果值等于true的话, 代表有商品
    private boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 消费者获取商品
    public synchronized void get() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("消费者取走了" + this.getBrand() + "---" + this.getName());

        // 消费者消费完标记false
        flag = false;

        // 唤醒生产者去消费
        notify();
    }

    // 生产者生产商品
    public synchronized void set(String brand, String name) {
        // 如果有产品, 那就等待
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 设置品牌
        this.setBrand(brand);

        // 睡醒
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 设置名字
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand() + "---" + this.getName());
        // 如果代码块执行到此处, 意味着已经生产完成
        flag = true;
        // 唤醒消费者去消费
        notify();
    }
}
