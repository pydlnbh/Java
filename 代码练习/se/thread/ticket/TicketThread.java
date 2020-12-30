package com.java.se.thread.ticket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.ticket
 */
public class TicketThread extends Thread {
    // 静态成员变量
    private static int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "-----" + "正在卖第" + (ticket--) + "张票");
            }
        }
    }

    // main
    public static void main(String[] args) {
        // 实例化
        TicketThread thread1 = new TicketThread();
        TicketThread thread2 = new TicketThread();
        TicketThread thread3 = new TicketThread();
        TicketThread thread4 = new TicketThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
