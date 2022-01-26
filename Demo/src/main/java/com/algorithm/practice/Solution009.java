package com.algorithm.practice;

/**
 * 01不等概率到01等概率随机
 */
public class Solution009 {

    /**
     * f()会以固定概率返回0和1,
     *
     * @return int
     */
    public static int f() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 等概率返回0和1
     *
     * @return int
     */
    public static int g() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == f());
        return ans;
    }

    public static void main(String[] args) {
        int length = 2;
        int[] counts = new int[length];
        int testTimes = 100000000;
        for (int i = 0; i < testTimes; i++) {
            counts[g()]++;
        }
        for (int i = 0; i < length; i++) {
            System.out.println(i + "出现了" + counts[i] + "次");
        }
    }
}
