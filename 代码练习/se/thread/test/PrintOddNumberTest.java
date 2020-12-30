package com.java.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class PrintOddNumberTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }
        }
    }

    public static void main(String[] args) {
        // 实例化
        PrintOddNumberTest printOddNumberTest = new PrintOddNumberTest();
        // 运行
        printOddNumberTest.start();

        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }
        }
    }
}
