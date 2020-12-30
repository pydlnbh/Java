package com.java.se.thread.ticket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.ticket
 */
public class TicketRunnableTest1 implements Runnable{
    // 初始化变量
    private int ticket = 5;

    // 重写方法
    @Override
    public void run() {
        // 线程调用同步方法
        sale();
    }

    // 同步方法
    public synchronized void sale() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "-----" + "正在出售第" + (ticket--) + "张票");
            }
        }
    }

    // main
    public static void main(String[] args) {
        TicketRunnableTest1 ticketRunnableTest1 = new TicketRunnableTest1();
        TicketRunnableTest1 ticketRunnableTest2 = new TicketRunnableTest1();
        TicketRunnableTest1 ticketRunnableTest3 = new TicketRunnableTest1();
        TicketRunnableTest1 ticketRunnableTest4 = new TicketRunnableTest1();
        Thread thread = new Thread(ticketRunnableTest1, "A");
        Thread thread1 = new Thread(ticketRunnableTest2, "B");
        Thread thread2 = new Thread(ticketRunnableTest2, "C");
        Thread thread3 = new Thread(ticketRunnableTest2, "D");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
