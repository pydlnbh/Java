package com.algorithm.study.practice;

public class Solution {

    /**
     * 无序相邻不相等数组二分找到局部最小值
     */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
//        if (left < right) { // 对数器测试 使用if出错 应该使用while 如下, 测试成功
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     *
     * @param arr
     */
    public static void printOddTimes(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (-eor);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                ans ^= arr[i];
            }
        }

        System.out.println("1: " + ans + ", 2: " + (ans ^ eor));
    }

    public static int km(int[] arr, int k, int m) {
        int ans = 0;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 4, 4, 4, 5, 5, 8, 8};
        printOddTimes(arr);
    }
}
