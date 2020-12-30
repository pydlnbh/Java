package com.java.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class ZhangSanWife implements Runnable {
    // 实例化账户
    Account account = new Account();

    public ZhangSanWife() {
    }

    public ZhangSanWife(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("张三的妻子取款");
                int money = account.getMoney();
                money -= 500;

                if (money < 0) {
                    System.out.println("余额不足以支付, 张三的妻子取款, 余额为 " + money);
                }
            }
        }
    }
}
