package com.algorithm.practice;

/**
 * 一个函数等概率返回 3 ~ 19, 变形为等概率返回 17 ~ 56
 */
public class Solution008 {

    public static void main(String[] args) {
        int k = 64;
        int[] counts = new int[k];
        int testTimes = 10000000;

        for (int i = 0; i < testTimes; i++) {
            counts[g()]++;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次。");
        }

    }

    /**
     * 给定函数等概率返回3 ~ 19
     *
     * @return int
     */
    public static int f() {
        // (int) [0, 1) * 17 -> [0, 16] + 3 -> [3, 19]
        return (int) (Math.random() * 17) + 3;
    }

    /**
     * 制作0~1等概率发生函数
     *
     * @return int
     */
    public static int f1() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 11);
        return ans < 11 ? 0 : 1;
    }

    /**
     * 使用7个二进制位制作0~63等概率发生
     *
     * @return int
     */
    public static int f2() {
        return (f1() << 7) + (f1() << 6) + (f1() << 5) + (f1() << 4) + (f1() << 3) + (f1() << 2) + (f1() << 1) + f1();
    }

    /**
     * 0 ~ 38等概率返回
     *
     * @return int
     */
    public static int f3() {
        int ans = 0;
        do {
            ans = f2();
        } while (ans > 39);
        return ans;
    }

    /**
     * 17 ~ 56 等概率返回
     *
     * @return int
     */
    public static int g() {
        return f3() + 17;
    }

}
