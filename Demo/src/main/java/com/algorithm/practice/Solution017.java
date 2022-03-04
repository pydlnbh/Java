package com.algorithm.practice;

import java.util.Arrays;

public class Solution017 {

    /**
     * 实现打印一个整数的二进制
     *
     * @param num 整数
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    /**
     * 给定一个参数N，返回1!+2!+3!+4!+…+N!的结果
     *
     * @param num 整数
     */
    public static int factorialSum(int num) {
        int ans = 0;
        int sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
            ans += sum;
        }
        System.out.println(ans);
        return ans;
    }

    /**
     * 实现冒泡排序
     *
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 实现选择排序
     *
     * @param arr 数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    /**
     * 插入排序
     *
     * @param arr 数组
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换方法
     *
     * @param arr 数组
     * @param i   下标i
     * @param j   下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 最大长度
     * @param maxValue 最大数值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((Math.random() + 1) * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 拷贝数组
     *
     * @param arr 数组
     * @return int[]
     */
    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return boolean
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if (arr1 == null || arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试方法
     */
    public static void testSort() {
        int testTimes = 10000;
        int maxSize = 1000;
        int maxValue = 1000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copyArray(arr);
//            bubbleSort(arr);
//            selectionSort(arr);
            insertionSort(arr);
            Arrays.sort(copyArray);
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }

    /**
     * main
     *
     * @param args 参数
     */
    public static void main(String[] args) {
//        printBinary(4);
//        factorialSum(3);
        testSort();
    }
}
