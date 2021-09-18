package com.algorithm.practice;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author pyd
 */
public class Solution001 {
    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 1000;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] source = generateRandomArray(maxSize, maxValue);
            int[] result = copyArray(source);

            // 排序
            // SelectionSort(source);
            // BubbleSort(source);
            InsertionSort(source);
            Arrays.sort(result);

            if (!isEqual(source, result)) {
                succeed = false;
                printArray(source, result);
                break;
            }
        }

        System.out.println(succeed ? "yes" : "no");
    }

    /**
     * 插入排序
     *
     * @param source
     */
    private static void InsertionSort(int[] source) {
        if (source == null || source.length < 2) {
            return;
        }

        for (int i = 1; i < source.length; i++) {
            for (int j = i - 1; j >= 0 && source[j] > source[j + 1]; j--) {
                swap(source, j, j + 1);
            }
        }
    }

    /**
     * 选择排序
     *
     * @param source
     */
    private static void SelectionSort(int[] source) {
        if (source == null || source.length < 2) {
            return;
        }

        for (int i = 0; i < source.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < source.length; j++) {
                minIndex = source[minIndex] > source[j] ? j : minIndex;
            }
            if (minIndex != i) {
                swap(source, i, minIndex);
            }
        }
    }

    /**
     * 冒泡排序
     */
    private static void BubbleSort(int[] source) {
        if (source == null || source.length < 2) {
            return;
        }

        for (int i = source.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换
     */
    private static void swap(int[] source, int i, int j) {
        source[i] = source[i] ^ source[j];
        source[j] = source[i] ^ source[j];
        source[i] = source[i] ^ source[j];
    }

    /**
     * 打印两个数组信息
     */
    private static void printArray(int[] source, int[] result) {
        if (source == null || result == null) {
            return;
        }

        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        for (int j : result) {
            System.out.print(j + " ");
        }

        System.out.println();
    }

    /**
     * 判断两个数组是否相等
     */
    private static boolean isEqual(int[] source, int[] result) {
        if ((source != null && result == null) || (source == null && result != null)) {
            return false;
        }

        if (source.length != result.length) {
            return false;
        }

        if (source == null && result == null) {
            return true;
        }

        for (int i = 0; i < source.length; i++) {
            if (source[i] != result[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 复制数组
     */
    private static int[] copyArray(int[] source) {
        if (source == null || source.length < 0) {
            return null;
        }

        int[] res = new int[source.length];

        for (int i = 0; i < source.length; i++) {
            res[i] = source[i];
        }

        return res;
    }

    /**
     * 生成随机新数组
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random() + 1)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }
}
