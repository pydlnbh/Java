package com.algorithm.primary.class03;

import java.util.Arrays;

/**
 * 二分查找对数器
 */
public class Code01_BSExist {

    /**
     * 二分查找
     *
     * @param arr 有序数组
     * @param num 数字
     * @return boolean
     */
    public static boolean find(int[] arr, int num) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 初始化变量
        int left = 0;
        int right = arr.length - 1;
        // 二分查找
        while (left <= right) {
            // 定义中点
            int mid = (left + right) / 2;
            // 判断
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 如果没找到, 返回 false
        return false;
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 最大长度
     * @param maxValue 最大数值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 生成随机长度
        int length = (int) ((Math.random() * maxSize) + 1);
        // 声明数组
        int[] arr = new int[length];
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 赋值
            arr[i] = (int) ((Math.random() * maxValue) + 1) - (int) (Math.random() * maxValue);
        }
        // 返回
        return arr;
    }

    /**
     * 生成随机数值
     *
     * @param maxValue 最大数值
     * @return int
     */
    public static int generateRandomNumber(int maxValue) {
        return (int) ((Math.random() * maxValue) + 1) - (int) (Math.random() * maxValue);
    }

    /**
     * 遍历查找
     *
     * @param arr 有序数组
     * @param value 数值
     * @return boolean
     */
    public static boolean test(int[] arr, int value) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 如果相等
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 打印数组
     *
     * @param arr 数组
     * @param value 要查找的数值
     */
    public static void printArray(int[] arr, int value) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 打印
            System.out.print(arr[i] + " ");
        }
        // 打印要查找的值
        System.out.print("查找: " + value);
        // 换行
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 666;
        int testTimes = 100000;
        boolean succeed = true;
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxSize, maxValue);
            // 排序
            Arrays.sort(arr);
            // 生成随机数
            int value = generateRandomNumber(maxValue);
            // 测试比对
            if (test(arr, value) != find(arr, value)) {
                // 打印数组和数值
                printArray(arr, value);
                // 赋值
                succeed = false;
                // 返回false终止循环
                break;
            }
        }
        // 打印
        System.out.println(succeed ? "yes" : "no");
    }
}
