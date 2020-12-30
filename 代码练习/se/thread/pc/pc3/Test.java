package com.java.se.thread.pc.pc3;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc3
 */
public class Test {
    // main
    public static void main(String[] args) {
        Goods goods = new Goods();

        Consumer consumer = new Consumer(goods);
        Producer producer = new Producer(goods);

        Thread thread = new Thread(consumer);
        Thread thread1 = new Thread(producer);

        thread1.start();
        thread.start();
    }
}
