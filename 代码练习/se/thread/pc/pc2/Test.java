package com.java.se.thread.pc.pc2;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.pc.pc2
 */
public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();

        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        Thread thread = new Thread(producer);
        Thread thread1 = new Thread(consumer);

        thread.start();
        thread1.start();
    }
}
