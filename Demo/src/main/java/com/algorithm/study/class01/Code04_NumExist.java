package com.algorithm.study.class01;

import java.util.Arrays;

/**
 * 在一个有序数组中, 找某个数是否存在
 *
 * @author peiyiding
 *  */
public class Code04_NumExist {

    public static boolean exist(int[] sortedArr, int num) {

        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid;

        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist001(arr, value)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Yes!" : "No!");
    }

    /**
     * 二分法查询num是否存在
     *
     * @param arr 有序数组
     * @param num 需要查找的数
     * @return boolean 是否查到标识
     */
    public static boolean exist001(int[] arr, int num) {
        if (null == arr ||
            0 == arr.length) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (num == arr[mid]) {
                return true;
            } else if (num > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return arr[left] == num;
    }

}
