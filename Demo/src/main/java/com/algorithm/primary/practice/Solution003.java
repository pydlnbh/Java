package com.algorithm.primary.practice;

/**
 * @author pyd
 */
public class Solution003 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 1, 1, 1, 3, 3, 3, 3};
        int[] arr1 = {5, 5, 5, 5, 1, 1, 1, 3, 3, 3, 3, 7, 7, 7};
        int[] arr2 = {5, 5, 5, 5, 6, 6, 6, 3, 3, 3, 3, 7, 7, 7, 7};
        printOddTimesNum(arr);
        printBinary(-100);
        printBinary(100);
        System.out.println(bitCounts(100));
        printOddTimes(arr1);
        onlyKTimes(arr2, 3, 4);
    }

    /**
     * 一个数组中出现了奇数次的数
     *
     * @param arr
     */
    public static void printOddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * 提取整形数最右侧的1
     *
     * @param num
     * @return int
     */
    public static int bitCounts(int num) {
        int count = 0;

        while (num != 0) {
            int rightOne = num & ((~num) + 1);
            count++;
            num ^= rightOne;
        }

        return count;
    }

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void printOddTimes(int[] arr) {
        int eor = 0;

        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (-eor);

        int onlyOne = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static int onlyKTimes(int[] arr, int k, int m) {
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

}
