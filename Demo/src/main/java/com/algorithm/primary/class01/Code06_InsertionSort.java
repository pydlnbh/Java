package com.algorithm.primary.class01;

import java.util.Arrays;

/**
 * @author peiyiding
 * @date 2021/12/25 21:22
 * @descption 插入排序对数器
 */
public class Code06_InsertionSort {

    /**
     * 插入排序
     *
     * @param arr 数组参数
     */
    public static void insertionSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 插入排序
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
     * @param arr 数组参数
     * @param i   下标i
     * @param j   下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对数器
     *
     * @param arr 数组参数
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 生成随机数组
     *
     * @param maxSize  数组最大长度
     * @param maxValue 数组最大值
     * @return int[] 随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 生成随机数组长度
        int[] arr = new int[(int) (maxSize * Math.random())];
        // 遍历赋值
        for (int i = 0; i < arr.length; i++) {
            // 赋值随机值
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 返回随机数组
        return arr;
    }

    /**
     * 赋值数组
     *
     * @param arr 数组参数
     */
    public static int[] copyArray(int[] arr) {
        // 判断边界条件
        if (arr == null) {
            return null;
        }
        // 复制数组
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        // 返回新数组
        return res;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param source 源数组
     * @param target 目标数组
     */
    public static boolean isEqual(int[] source, int[] target) {
        // 如果源数组和目标数组一个为空，另一个不为空，返回false
        if ((source == null && target != null) || (source != null && target == null)) {
            return false;
        }
        // 如果源数组和目标数组都为空
        if (source == null && target == null) {
            return true;
        }
        // 如果源数组长度和目标长度不相等
        if (source.length != target.length) {
            return false;
        }
        // 遍历
        for (int i = 0; i < source.length; i++) {
            // 如果数组值不相等，返回false
            if (source[i] != target[i]) {
                return false;
            }
        }
        // 如果以上条件都不满足，返回true
        return true;
    }

    /**
     * 打印数组
     *
     * @param arr 数组参数
     */
    public static void printArray(int[] arr) {
        // 判断边界条件
        if (arr == null) {
            return;
        }
        // 打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTimes = 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            int[] source = generateRandomArray(maxSize, maxValue);
            int[] target = copyArray(source);
            insertionSort(source);
            comparator(target);
            if (!isEqual(source, target)) {
                flag = false;
                printArray(source);
                printArray(target);
                break;
            }
        }
        // 打印结果
        System.out.println(flag ? "yes" : "no");
    }
}
