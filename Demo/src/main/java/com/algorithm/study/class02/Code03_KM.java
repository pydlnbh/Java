package com.algorithm.study.class02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 一个数组中有一种数出现K次，其他数都出现了M次， M > 1, K < M 找到，出现了K次的数， 要求，额外空间复杂度O(1)，时间复杂度O(N)
 *
 * @author peiyiding
 * */
public class Code03_KM {

/*    public static int test(int[] arr, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return -1;
    }

    public static int onlyTimes(int[] arr, int k, int m) {
        int[] t = new int[32];

        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 12, 4, 1, 24, 23, 52, 22, 22, 33, 33, 33};
        int i = onlyTimes(arr, 2, 3);
        System.out.println(i);
    }*/

    public static int testOnlyKTimesNum(int[] arr, int k, int m) {
        Map<Integer, Integer> testMap = new HashMap<>();
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
            }
        }

        return ans;
    }

    /**
     * 生成随机数组
     *
     * @param kinds 出现数字的种类
     * @param k k次
     * @param m m次
     * @return int[] 数组
     */
    public static int[] generateRandomArray(int kinds, int range, int k, int m) {
        int kNum = generateRandomNum(range);

        int numKinds = (int) (Math.random() * kinds) + 2;

        int[] ans = new int[k + (numKinds - 1) * m];
        int index= 0;
        for (; index < k; index++) {
            ans[index] = kNum;
        }

        numKinds--;

        HashSet<Integer> set = new HashSet<>();
        set.add(kNum);

        while (numKinds > 0) {
            int num;
            do {
                num = generateRandomNum(range);
            } while (set.contains(num));
            set.add(num);
            numKinds--;

            for (int i = 0; i < m; i++) {
                ans[index++] = num;
            }
        }

        // 打乱排序
        for (int i = 0; i < ans.length; i++) {
            int j = (int) (Math.random() * ans.length);
            int temp = ans[i];
            ans[i] = temp;
            temp = ans[j];
        }

        return ans;
    }

    public static int generateRandomNum(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static int onlyKTimesNum(int[] arr, int k, int m) {
        int[] t = new int[32];

        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) != 0) {
                    t[i]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++){
            if ((t[i] % m) != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }

    public static void main(String[] args){

//        int[] arr1 = {9, 6, 6, 6, 1, 1, 1, 4, 4, 4, 7, 7, 7, 2, 2, 2, 5, 5, 5, 3, 3, 3, 8, 8, 8};
//        int aa = onlyKTimesNum(arr1, 1, 3);
//        System.out.println(aa);

        int kinds = 10;
        int testTimes = 50;
        int max = 9;
        int range = 20;

        System.out.println("start");

        for (int i = 0; i < testTimes; i++) {
            int kind1 = (int) (Math.random() * max) + 1; // 1 ~ 9
            int kind2 = (int) (Math.random() * max) + 1;

            int k = Math.min(kind1, kind2);
            int m = Math.max(kind1, kind2);

            if (k == m) {
                m = k + 1;
            }

            int[] arr = generateRandomArray(kinds, range, k, m);

            int k1 = testOnlyKTimesNum(arr, k, m);
            int k2 = onlyKTimesNum(arr, k, m);
            if (k1 != k2) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
                System.out.println(k1);
                System.out.println(k2);
                System.out.println("Oops!");
            }
        }

        System.out.println("end");
    }

}
