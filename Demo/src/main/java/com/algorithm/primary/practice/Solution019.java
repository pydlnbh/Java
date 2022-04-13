package com.algorithm.primary.practice;

import java.util.Arrays;

public class Solution019 {

    /**
     * 有序数组中找到num
     *
     * @param sortedArray 有序数组
     * @param num 数字
     * @return boolean
     */
    public static boolean bsSearch(int[] sortedArray, int num) {
        if (sortedArray == null || sortedArray.length == 0) {
            return false;
        }
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (sortedArray[mid] == num) {
                return true;
            } else if (sortedArray[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 有序数组中找到>=num最左的位置
     *
     * @param sortedArray 有序数组
     * @param num 数字
     * @return int
     */
    public static int nearLeftIndex(int[] sortedArray, int num) {
        int index = -1;
        if (sortedArray == null || sortedArray.length == 0) {
            return index;
        }
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    /**
     * 有序数组中找到<=num最右的位置
     *
     * @param sortedArray 有序数组
     * @param num 数字
     * @return int
     */
    public static int nearRightIndex(int[] sortedArray, int num) {
        int index = -1;
        if (sortedArray == null || sortedArray.length == 0) {
            return index;
        }
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    /**
     * 局部最小值问题
     *
     * @param arr 数组
     * @return int
     */
    public static int minIndexValue(int[] arr) {
        int length;
        int index = -1;
        if (arr == null || (length = arr.length) == 0) {
            return index;
        }
        if (arr[0] < arr[1] || arr.length == 1) {
            return 0;
        }
        if (arr[length - 1] < arr[length - 2]) {
            return length - 1;
        }
        int left = 0;
        int right = length - 1;
        while (left < right - 1) {
             int mid = (left + right) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]) {
                return mid;
            } else {
                if (arr[mid + 1] > arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return arr[left] < arr[right] ? left : right;
    }

    /**
     * 实现有序数组中找到num
     */
    public static void testBsSearch() {
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomSortedArray(maxSize, maxValue);
            int num = generateRandomValue(maxValue);
            if (test(arr, num) != bsSearch(arr, num)) {
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("测试结束");
    }

    /**
     * 测试有序数组中找到>=num最左的位置
     */
    public static void testNearLeftIndex() {
        int index = 3;
        int[] sortedArray = {1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 66, 346};
        int i = nearLeftIndex(sortedArray, index);
        System.out.println(i + ": " + sortedArray[i]);
    }

    /**
     * 测试有序数组中找到<=num最右的位置
     */
    public static void testNearRightIndex() {
        int index = 3;
        int[] sortedArray = {1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 66, 346};
        int i = nearRightIndex(sortedArray, index);
        System.out.println(i + ": " + sortedArray[i]);
    }

    /**
     * 测试局部最小值问题
     */
    public static void testMinIndexValue() {
        int[] arr = {3, 2, 1, 4, 1, 2, 14, 12, 4, 22};
        int i = minIndexValue(arr);
        System.out.println(i + ": " + arr[i]);
    }

    /**
     * 生成随机数组(排序后)
     *
     * @param maxSize 数组最大长度
     * @param maxValue 数组最大值
     * @return int[]
     */
    public static int[] generateRandomSortedArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        Arrays.sort(arr);
        return arr;
    }

    /**
     * 生成随机数
     *
     * @param maxValue 最大值
     * @return int
     */
    public static int generateRandomValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    /**
     * 测试数组是否找到num
     *
     * @param arr 数组
     * @param num 数字
     * @return boolean
     */
    public static boolean test(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 主方法
     *
     * @param args 标准形参
     */
    public static void main(String[] args) {
//        testBsSearch();
//        testNearLeftIndex();
//        testNearRightIndex();
        testMinIndexValue();
    }
}
