package com.algorithm.practice;

import java.util.Arrays;

public class Solution002 {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 1000;
        int testTimes = 1;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] source = generateRandomArray(maxSize, maxValue);

            // test
            getLessIndex(source);

            int[] result = Arrays.stream(source).distinct().sorted().toArray();

            int num = generateRandomNum(result);
            boolean flag = exist(result, num);

            if (!flag) {
                System.out.println(Arrays.toString(result));
                System.out.println("search: " + num + ", true or false: " + flag);
                break;
            }
        }

        System.out.println(succeed ? "yes" : "no");
    }

    /**
     * 生成随机数字
     *
     * @param result
     * @return
     */
    private static int generateRandomNum(int[] result) {
        if (result == null || result.length == 0) {
            return 0;
        }

        int length = (int) (result.length * Math.random());
        int num = result[length];
        return num;
    }

    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return int[]
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        // [0, 1) ---> [0, 1) * (5 + 1) ---> (int) [0, 6) ---> [0, 5]
        // [0, 1) ---> ([0, 1) * 5) + 1 ---> (int) [1, 6) ---> [1, 5]
        int[] arr = new int[(int) ((maxSize * Math.random()) + 1)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }

    /**
     * 在有序数组中存在某个数
     *
     * @param result 有序数组
     * @param num    查找到的数
     * @return boolean
     */
    private static boolean exist(int[] result, int num) {
        if (result == null || result.length == 0) {
            return false;
        }
        int begin = 0;
        int end = result.length - 1;
        int mid = 0;

        while (begin < end) {
            mid = begin + ((end - begin) >> 1);
            if (result[mid] == num) {
                return true;
            } else if (result[mid] < num) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result[begin] == num;
    }

    /**
     * 在一个有序数组中, 找到大于等于某个数最左侧的位置
     *
     * @param arr   有序数组
     * @param value 查找的数值
     * @return int 下标
     */
    public static int nearestLeftIndex(int[] arr, int value) {
        int begin = 0;
        int end = arr.length - 1;
        int index = -1;

        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return index;
    }

    /**
     * 在一个有序数组中, 找到小于等于某个数最右侧的位置
     *
     * @param arr 数组
     * @param num 需要查找的值
     * @return int 右侧位置
     */
    public static int nearestRightIndex(int[] arr, int num) {
        int begin = 0;
        int end = arr.length - 1;
        int index = -1;

        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if (arr[mid] <= num) {
                index = mid;
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }

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

        int begin = 1;
        int end = arr.length - 2;
        int mid = 0;
        while (begin < end) {
            mid = begin + ((end - begin) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                end = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }

        return begin;
    }
}
