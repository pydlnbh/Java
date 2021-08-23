package com.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class SleepTest {
    public static void main(String[] args) {
        Run run = new Run();
        Thread thread = new Thread(run);

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            if (i == 3) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
