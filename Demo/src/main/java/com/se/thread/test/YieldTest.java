package com.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class YieldTest {
    // main
    public static void main(String[] args) {
        // 实例化
        Run run = new Run();
        Thread thread = new Thread(run);

        // 就绪状态
        thread.start();

        // 循环遍历
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Thread.yield();
                // thread.stop();
                System.out.println(Thread.currentThread().getName() + "-----" + i + "礼让一次");
            } else {
                System.out.println(Thread.currentThread().getName() + "-----" + i);
            }
        }
    }
}
