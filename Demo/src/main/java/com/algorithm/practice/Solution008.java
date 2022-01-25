package com.algorithm.practice;

/**
 * 一个函数等概率返回 3 ~ 19, 变形为等概率返回 17 ~ 56
 */
public class Solution008 {

    public static void main(String[] args) {
        int k = 17;
        int[] counts = new int[k];
        int testTimes = 10000000;

        for (int i = 0; i < testTimes; i++) {
            counts[m4()]++;
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
        return (f1() << 5) + (f1() << 4) + (f1() << 3) + (f1() << 2) + (f1() << 1) + f1();
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

    /**
     * 给定等概率返回 3 ~ 13 的函数, 返回一个等概率返回 5 ~ 16的函数
     */

    /**
     * 等概率返回 3 ~ 13 的函数
     *
     * @return int
     */
    public static int fun() {
        // Math.random() -> [0, 1) -> (int) Math.random() * 11 -> [0, 10] + 3 -> [3, 13]
        return (int) (Math.random() * 11) + 3;
    }

    /**
     * 3 4 5 6 7  8  9 10 11 12 13
     * <p>
     * 等概率返回[0, 1]
     *
     * @return int
     */
    public static int fun01() {
        int ans = 0;
        do {
            ans = fun();
        } while (ans == 8);
        return ans < 8 ? 0 : 1;
    }

    /**
     * 4       3       2       1       0
     * 16      8       4       2       1
     * 0~15    0~7     0~3     0~1      1
     *
     * 等概率返回 0~16
     *
     * @return int
     */
    public static int fun02() {
        return (fun01() << 3) + (fun01() << 2) + (fun01() << 1) + fun01();
    }

    /**
     * 0 ~ 16
     * 5 ~ 16
     *
     * @return int
     */
    public static int fun03() {
        int ans = 0;
        do {
            ans = fun02();
        } while (ans < 4);
        return ans;
    }

    /**
     * 等概率返回 5 ~ 16
     *
     * @return int
     */
    public static int fun04() {
        return fun03() + 1;
    }

    /**
     * 给定概率2 ~ 8, 得到 1 ~ 10
     */

    /**
     * 2 ~ 9等概率返回
     *
     * @return int
     */
    public static int m() {
        // ([0, 1) * 8) + 2 -> [2, 9]
        return (int) (Math.random() * 8) + 2;
    }

    /**
     * 2 3 4 5 6 7 8 9
     *
     * @return int
     */
    public static int m1() {
        int ans = m();
        return ans < 6 ? 0 : 1;
    }

    /**
     * 等概率返回 0 ~ 15
     *
     * @return int
     */
    public static int m2() {
        return (m1() << 3) + (m1() << 2) + (m1() << 1) + m1();
    }

    /**
     * 等概率返回 0 ~ 9
     *
     * @return int
     */
    public static int m3() {
        int ans = 0;
        do {
            ans = m2();
        } while (ans > 9);
        return ans;
    }

    /**
     * 等概率返回1 ~ 10
     * @return
     */
    public static int m4() {
        return m3() + 1;
    }

}
