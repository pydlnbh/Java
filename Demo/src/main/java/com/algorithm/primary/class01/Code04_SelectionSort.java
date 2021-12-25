package com.algorithm.primary.class01;

import java.util.Arrays;

/**
 * @author peiyiding
 * @date 2021/12/25 19:57
 * @descption 选择排序对数器
 */
public class Code04_SelectionSort {

    /**
     * 选择排序
     *
     * @param arr 参数
     */
    public static void selectionSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 交换方法
     *
     * @param arr 参数
     * @param i 下标i
     * @param j 下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 比较器
     *
     * @param arr 数组
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 数组最大长度
     * @param maxValue 数组最大值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 随机数组长度
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            // 赋值随机数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 返回随机数组
        return arr;
    }

    /**
     * 复制数组
     *
     * @param arr 参数
     * @return int[]
     */
    public static int[] copyArray(int[] arr) {
        // 边界条件
        if (arr == null) {
            return null;
        }
        // 复制新数组
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
     * @return boolean
     */
    public static boolean isEqual(int[] source, int[] target) {
        // 如果源数组为空，目标数组不为空，返回false
        if ((source == null && target != null) || (source != null && target == null)) {
            return false;
        }
        // 如果源数组和目标数组都为空，返回true
        if (source == null && target == null) {
            return true;
        }
        // 如果源数组和目标数组的长度不相等，返回false
        if (source.length != target.length) {
            return false;
        }
        // 遍历数组
        for (int i = 0; i < source.length; i++) {
            // 如果参数不相等，返回false
            if (source[i] != target[i]) {
                return false;
            }
        }
        // 以上条件不满足，返回true
        return true;
    }

    /**
     * 打印数组方法
     *
     * @param arr 参数
     */
    public static void printArray(int[] arr) {
        // 边界条件
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
            int[] soure = generateRandomArray(maxSize, maxValue);
            int[] target = copyArray(soure);
            selectionSort(soure);
            comparator(target);
            if (!isEqual(soure, target)) {
                flag = false;
                printArray(soure);
                printArray(target);
                break;
            }
        }
        System.out.println(flag ? "yes" : "no");
    }
}
