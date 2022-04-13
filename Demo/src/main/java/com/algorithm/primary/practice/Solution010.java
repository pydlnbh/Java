package com.algorithm.primary.practice;

import java.util.Arrays;

/**
 * 选择排序、冒泡排序、插入排序对数器
 */
public class Solution010 {

    /**
     * 生成随机数组
     *
     * @param maxSize  最大长度
     * @param maxValue 最大数值
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 随机数组长度
        int length = (int) ((Math.random() + 1) * maxSize);
        // 声明随机数组
        int[] arr = new int[length];
        // 遍历长度
        for (int i = 0; i < arr.length; i++) {
            // 赋随机值
            arr[i] = (int) ((Math.random() + 1) * maxValue) - (int) (Math.random() * maxValue);
        }
        // 返回
        return arr;
    }

    /**
     * 拷贝数组
     *
     * @param arr 需要拷贝的数组
     */
    public static int[] copyArray(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 1) {
            return null;
        }
        // 声明新数组
        int[] res = new int[arr.length];
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 赋值
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 选择排序
     *
     * @param arr 排序的数组
     */
    public static void selectionSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 声明最小值下标
            int minIndex = i;
            // 循环遍历
            for (int j = 0; j <= i; j++) {
                // 比较赋值
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 交换
            swap(arr, i, minIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 需要排序的数组
     */
    public static void bubbleSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环遍历
        for (int i = arr.length - 1; i > 0; i--) {
            // 循环遍历
            for (int j = 0; j < i; j++) {
                // 判断
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环遍历
        for (int i = 1; i < arr.length; i++) {
            // 双层遍历
            for (int j = i - 1; j >= 0; j--) {
                // 判断
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
     * @param i 下标i
     * @param j 下标j
     */
    private static void swap(int[] arr, int i, int j) {
        // t = a
        int t = arr[i];
        // a = b
        arr[i] = arr[j];
        // b = t
        arr[j] = t;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param source 源数组
     * @param target 目标数组
     */
    public static boolean isEqual(int[] source, int[] target) {
        // 循环遍历
        for (int i = 0; i < source.length; i++) {
            // 如果不相等
            if (source[i] != target[i]) {
                // 返回 false
                return false;
            }
        }
        // 返回 true
        return true;
    }

    /**
     * 打印两个数组
     *
     * @param printArr  未排序的数组
     * @param arr       数组
     * @param copyArray 拷贝数组
     */
    public static void printArray(int[] printArr, int[] arr, int[] copyArray) {
        // 循环遍历
        for (int i = 0; i < printArr.length; i++) {
            // 打印
            System.out.print(printArr[i] + " ");
        }
        // 换行
        System.out.println();
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 打印
            System.out.print(arr[i] + " ");
        }
        // 换行
        System.out.println();
        // 循环遍历
        for (int i = 0; i < copyArray.length; i++) {
            // 打印
            System.out.print(copyArray[i] + " ");
        }
        // 换行
        System.out.println();
    }

    /**
     * 主方法
     *
     * @param args 标准形参
     */
    public static void main(String[] args) {
        int maxSize = 1000;
        int maxValue = 6666;
        int testTimes = 10000;
        boolean succeed = true;

        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxSize, maxValue);
            // 复制数组
            int[] copyArr = copyArray(arr);
            // 备份数组
            int[] printArr = copyArray(arr);
            // 自己写的排序算法
            selectionSort(arr);
            bubbleSort(arr);
//            insertSort(arr);
            // 系统提供的排序算法
            Arrays.sort(copyArr);
            // 如果两个数组不相同
            if (!isEqual(arr, copyArr)) {
                // 打印数组
                printArray(printArr, arr, copyArr);
                // 赋值
                succeed = false;
                // 结束循环
                break;
            }
        }

        // 打印测试结果
        System.out.println(succeed ? "yes" : "no");
    }
}
