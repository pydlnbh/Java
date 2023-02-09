package com.algorithm.study.class02;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 一个数组中有一种数出现K次，其他数都出现了M次， M > 1, K < M 找到，出现了K次的数， 如果出现k次就返回k，没有出现k次就返回-1
 *
 * @author peiyiding
 */
public class Code04_KM1 {
    /**
     * main
     *
     * @param args 标准入参
     */
    public static void main(String[] args) {
//        int[] arr = {-14, -58, 50, -58, -58, -58, -14, -58, 50, -14, -58, 50, 50, -14, 50, -58, -58, 50, 50, 50 };
//        int i = testOnlyKTimes(arr, 4, 8);
//        System.out.println(i);
        test();
    }

    /**
     * 对数器
     */
    public static void test() {
        int max = 10;
        int range = 200;
        int maxKinds = 20;
        int testTimes = 10000;

        System.out.println("start");

        for (int i = 0; i < testTimes; i++) {
            int t1 = (int) (Math.random() * max) + 1;
            int t2 = (int) (Math.random() * max) + 1;

            // k < m
            int k = Math.min(t1, t2);
            int m = Math.max(t1, t2);

            if (k == m) {
                m = k + 1;
            }

            int[] arr = generateRandomArray(maxKinds, range, k, m);

            int ans1 = testOnlyKTimes(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);

            if (ans1 != ans2) {
                for (int num : arr) {
                    System.out.print(num + ", ");
                }
                System.out.println();
                System.out.println("testMethod: " + ans1 + ", myMethod: " + ans2);
                System.out.println("Oops");
            }
        }

        System.out.println("end");
    }

    /**
     * 算法结果
     *
     * @param arr 数组
     * @param k k次
     * @param m m次
     * @return int 出现k次的数或-1
     */
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];

        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
//                if (((num >> i) & 1) != 0) {
//                    t[i]++;
//                }
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }

            if (t[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }
        }

        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }

            if (count != k) {
                return -1;
            }
        }

        return ans;
    }

    /**
     * 对数器测试代码
     *
     * @param arr 数组
     * @param k k次
     * @param m m次
     * @return int 出现k次的数或-1
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

        for (int num : arr) {
            if (testMap.get(num) == k) {
                ans = num;
                break;
            } else {
                ans = -1;
            }
        }

        return ans;
    }

    /**
     * 生成随机数组
     *
     * @param maxKinds 最大种类数
     * @param range 最大数
     * @param k k次
     * @param m m次
     * @return int[] 随机数组
     */
    public static int[] generateRandomArray(int maxKinds, int range, int k, int m) {
        int kNum = generateRandomNum(range);

        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);

        int numKinds = (int) (Math.random() * maxKinds) + 2;

        int[] ans = new int[times + (numKinds - 1) * m];

        int index = 0;
        for (; index < times; index++) {
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
     * 生成随机数
     *
     * @param range 最大数
     * @return int 随机数
     */
    public static int generateRandomNum(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

}
