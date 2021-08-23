package com.se.thread.ticket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/30
 * @Description: com.java.se.thread.ticket
 */
public class Test {
    private int i = 4;

    public void count() {
        int i = 3;
        int j = 3;
        i--;
        System.out.println(i--); // 2
        System.out.println(--j); // 3
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.count();
    }
}
