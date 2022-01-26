package com.algorithm.primary.class03;

import java.util.Arrays;

/**
 * 有序数组中找到>=num最左的位置 + 对数器
 *
 * 1 1 2 2 3 3 3 4 4 5 5 6 6 6 7 7 8 8 9 10            num: 6
 *                       ^
 */
public class Code02_BSNearLeft {

    /**
     * 大于等于value最左侧的数值下标
     *
     * @param arr 有序数组
     * @param value 要查找的数值
     * @return int
     */
    public static int nearLeft(int[] arr, int value) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 声明变量
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        // 循环
        while (left <= right) {
            // 定义中点
            int mid = (left + right) / 2;
            // 判断
            if (arr[mid] >= value) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 返回下标
        return res;
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 数组最大长度
     * @param maxValue 数组最大值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 初始数组长度
        int[] arr = new int[(int) ((maxSize * Math.random()) + 1)];
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 赋随机值
            arr[i] = (int) ((Math.random() * maxValue) + 1) - (int) (Math.random() * maxValue);
        }
        // 返回
        return arr;
    }

    /**
     * 生成随机数值
     *
     * @param maxValue 数组最大值
     * @return int
     */
    public static int generateRandomValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    /**
     * 遍历查找
     *
     * @param arr 有序数组
     * @param value 数值
     * @return int
     */
    public static int test(int[] arr, int value) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 判断
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 打印数组
     *
     * @param arr 数组
     */
    public static void print(int[] arr, int value) {
        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 打印
            System.out.print(arr[i] + " ");
        }
        // 打印
        System.out.println("***" + value + "***");
    }

    public static void main(String[] args) {
        // 定义变量
        int maxSize = 100;
        int maxValue = 555;
        int testTimes = 50000;
        boolean succeed = true;
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(maxSize, maxValue);
            // 生成随机数值
            int value = generateRandomValue(maxValue);
            // 排序
            Arrays.sort(arr);
            // 判断
            if (test(arr, value) != nearLeft(arr, value)) {
                // 赋值
                succeed = false;
                // 打印
                print(arr, value);
                // 出错结束循环
                break;
            }
        }
        // 打印测试结果
        System.out.println(succeed ? "yes" : "no");
    }
}
