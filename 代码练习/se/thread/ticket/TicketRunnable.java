package com.java.se.thread.ticket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.ticket
 */
public class TicketRunnable implements Runnable {
    // 定义成员变量
    private int ticket = 5;

    // 重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "----" + "正在卖第" + (ticket--) + "张票");
            }
        }
    }

    // main
    public static void main(String[] args) {
        // 实例化
        TicketRunnable ticketRunnable = new TicketRunnable();

        // 通过带参的构造方法进行实例化
        Thread thread1 = new Thread(ticketRunnable);
        Thread thread2 = new Thread(ticketRunnable);
        Thread thread3 = new Thread(ticketRunnable);
        Thread thread4 = new Thread(ticketRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
