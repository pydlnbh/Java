package com.java.se.thread.ticket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.ticket
 */
public class TicketRunnableTest implements Runnable {
    // 初始化变量
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 睡眠
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 同步锁
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "-----" + "正在出售第" + (ticket--) + "张票");
                }
            }
        }
    }

    // main
    public static void main(String[] args) {
        // 实例化
        TicketRunnableTest ticketRunnableTest = new TicketRunnableTest();
        Thread thread = new Thread(ticketRunnableTest, "A");
        Thread thread1 = new Thread(ticketRunnableTest, "B");
        Thread thread2 = new Thread(ticketRunnableTest, "C");
        Thread thread3 = new Thread(ticketRunnableTest, "D");

        // 就绪状态
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
