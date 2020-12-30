package com.java.se.thread.pc.pc2;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc2
 */
public class Goods {
    // 变量
    private String brand;
    private String name;

    public Goods() {
    }

    public Goods(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

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
        // 睡醒
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印
        System.out.println("消费者取走了" + this.getBrand() + "---" + this.getName());
    }

    // 生产者生产商品
    public synchronized void set(String brand, String name) {
        // 设置品牌
        this.setBrand(brand);

        // 睡眠
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 设置名字
        this.setName(name);

        // 打印
        System.out.println("生产者生产了" + this.getBrand() + "---" + this.getName());
    }
}
