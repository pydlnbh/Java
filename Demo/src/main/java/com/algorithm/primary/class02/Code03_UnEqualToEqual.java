package com.algorithm.primary.class02;

/**
 * 从0~1不等概率随机 到 0 ~ 1等概率随机
 */
public class Code03_UnEqualToEqual {

    /**
     * 0~1不等概率随机
     *
     * @return int
     */
    public static int f() {
        double ans = Math.random();
        return ans < 0.22 ? 0 : 1;
    }

    /**
     * 0 ~ 1等概率随机
     *
     * @return int
     */
    public static int g() {
        int ans;
        do {
            ans = f();
        } while (ans == f());
        return ans;
    }

    public static int f01() {
        return Math.random() < 0.22 ? 0 : 1;
    }

    public static int f02() {
        int ans = 0;
        do {
            ans = f01();
        } while (ans == f01());
        return ans;
    }

    public static void main(String[] args) {
        int testTimes = 32421123;
        int[] couts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            couts[f02()]++;
        }
        for (int i = 0; i < couts.length; i++) {
            System.out.println(i + "这个数出现了" + couts[i] + "次!");
        }
    }
}
