package com.algorithm.study.practice;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 一个数组中有一种数出现K次，其他数都出现了M次，
 * 已知M > 1，K < M，找到出现了K次的数
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Solution004 {
    /**
     * main
     *
     * @param args 标准入参
     */
    public static void main(String[] args) {
        test();
    }

    /**
     * 对数器
     */
    public static void test() {
        int max = 10;
        int range = 100;
        int numKindsMax = 20;
        int testTimes = 10;

        System.out.println("start");

        for (int i = 0; i < testTimes; i++) {
            int t1 = (int) (Math.random() * max) + 1;
            int t2 = (int) (Math.random() * max) + 1;

            int k = Math.min(t1, t2);
            int m = Math.max(t1, t2);

            if (k == m) {
                m = k + 1;
            }

            int[] arr = generateRandomArray(numKindsMax, range, k, m);

            int ans1 = testOnlyKTimes(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);

            if (ans1 != ans2) {
                for (int num : arr) {
                    System.out.print(num + ", ");
                }
                System.out.println();
                System.out.println("测试方法: " + ans1 + "解题方法: " + ans2);
                System.out.println("Oops");
                break;
            }
        }

        System.out.println("end");
    }

    /**
     * 解题方法
     *
     * @param arr 数组
     * @param k 出现k次
     * @param m 出现m次
     * @return int 出现k次的数
     */
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];

        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if ((t[i] % m) != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }

    /**
     * 对数期测试方法
     * 
     * @param arr 数组 
     * @param k 出现k次
     * @param m 出现m次
     * @return 出现k次的数
     */
    public static int testOnlyKTimes(int[] arr, int k, int m) {
        HashMap<Integer, Integer> testMap = new HashMap<>();
        for (int num : arr) {
            if (testMap.containsKey(num)) {
                testMap.put(num, testMap.get(num) + 1);
            } else {
                testMap.put(num, 1);
            }
        }

        int ans = 0;

        for (int iNum : arr) {
            if (testMap.get(iNum) == k) {
                ans = iNum;
                break;
            }
        }

        return ans;
    }

    /**
     * 生产随机数组
     *
     * @param numsKindsMax 不同种数个数的最大值
     * @param range 出现数的最大值
     * @param k 出现k次
     * @param m 出现m次
     * @return int[] 随机数组
     */
    public static int[] generateRandomArray(int numsKindsMax, int range, int k, int m) {
        // 先生成要找到的数
        int kNum = generateRandomNum(range);
        // 再生成不同种树的个数
        int numKinds = (int) (Math.random() * numsKindsMax) + 2;

        int[] ans = new int[k + (numKinds - 1) * m];

        int index = 0;
        for (; index < k; index++) {
            ans[index] = kNum;
        }

        numKinds--;

        HashSet<Integer> set = new HashSet<>();
        set.add(kNum);

        while (numKinds > 0) {
            int curNum;
            do {
                curNum = generateRandomNum(range);
            } while (set.contains(curNum));
            set.add(curNum);

            numKinds--;

            for (int i = 0; i < m; i++) {
                ans[index++] = curNum;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            int j = (int) (Math.random() * ans.length);
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
        }

        return ans;
    }

    /**
     * 生产随机数值
     *
     * @param range 最大值
     * @return int -range ~ range
     */
    public static int generateRandomNum(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }
}
