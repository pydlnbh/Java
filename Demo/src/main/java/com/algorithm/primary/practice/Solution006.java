package com.algorithm.primary.practice;

/**
 * @author peiyiding
 * @date 2022/1/5 10:58
 * @descption 随机数练习
 */
public class Solution006 {

    public static void main(String[] args) {
        int testTimes = 100000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.6) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);

        int k = 10;

        int[] counts = new int[k];
        for (int i = 0; i < testTimes; i++) {
            // [0, k - 1]
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了 " + counts[i] + "次！");
        }

        count = 0;
        double x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (xToxPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));
    }

    public static double xToxPower2() {
        return Math.max(Math.random(), Math.random());
    }
}