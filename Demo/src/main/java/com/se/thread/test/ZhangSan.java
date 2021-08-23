package com.se.thread.test;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.test
 */
public class ZhangSan implements Runnable{
    // 实例化账户
    Account account = new Account();

    public ZhangSan() {
    }

    public ZhangSan(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("张三准备取款");
                int money = account.getMoney();
                money -= 200;

                if (money < 0) {
                    System.out.println("账户余额不足, 张三取款, 余额为 " + money);
                }
            }
        }
    }
}
