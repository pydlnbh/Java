package com.algorithm.study.class01;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author James
 */
public class Code03_InsertionSort {

    // 插入排序
    public static void InsertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // 交换
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // 使用系统的排序进行比较
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 复制数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 比较两个数组是否相等
    public static boolean isEqual(int[] arr, int[] res) {
        if ((arr == null && res != null) || (arr != null && res == null)) {
            return false;
        }

        if (arr == null && res == null) {
            return true;
        }

        if (arr.length != res.length) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != res[i]) {
                return false;
            }
        }

        return true;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 主方法
    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] res = copyArray(arr);

            // 排序
            InsertionSort(arr);
            comparator(res);

            if (!isEqual(arr, res)) {
                succeed = false;
                printArray(arr);
                printArray(res);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked");

        // 打印
        int[] arr = generateRandomArray(maxSize, maxValue);
        InsertionSort(arr);
        printArray(arr);
    }

}