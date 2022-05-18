package com.algorithm.study.class02;

import java.util.HashMap;

/**
 * 一个数组中有一种数出现K次，其他数都出现了M次， M > 1, K < M 找到，出现了K次的数， 要求，额外空间复杂度O(1)，时间复杂度O(N)
 *
 * @author pyd
 * */
public class Code03_KM {

    public static int test(int[] arr, int m, int k) {
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
    }
}
