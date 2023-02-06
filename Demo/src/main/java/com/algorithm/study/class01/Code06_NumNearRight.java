package com.algorithm.study.class01;

import java.util.Arrays;

/**
 * 在一个有序数组中, 找出<=某个数最右侧的位置
 *
 * @author peiyiding
 */
public class Code06_NumNearRight {

    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return index;
    }

    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTimes = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());

            if (test(arr, value) != nearRight001(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestIndex(arr, value));
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Yes" : "No");
    }

    /**
     * 找到<=num最右侧的位置
     *
     * @param arr 有序数组
     * @param num 对比数字
     * @return int 下标
     */
    public static int nearRight001(int[] arr, int num) {
        if (null == arr ||
            0 == arr.length) {
            return -1;
        }

        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (num >= arr[mid]) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

}
