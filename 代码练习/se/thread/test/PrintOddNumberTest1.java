package com.java.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class PrintOddNumberTest1 implements Runnable{
    // 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "-----" + i);
            }
        }
    }

    // main
    public static void main(String[] args) {
        PrintOddNumberTest1 printOddNumberTest1 = new PrintOddNumberTest1();
        Thread thread = new Thread(printOddNumberTest1);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "-----" + i);
            }
        }
    }
}
