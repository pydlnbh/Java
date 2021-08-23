package com.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class AccountTest {
    // main
    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan();
        ZhangSanWife zhangSanWife = new ZhangSanWife();
        Thread thread = new Thread(zhangSan);
        Thread thread1 = new Thread(zhangSanWife);

        thread.start();
        thread1.start();
    }
}
