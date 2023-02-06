package com.algorithm.study.class02;

public class Code01_Swap {

    /**
     * 交换两个数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxSize + 1) * Math.random()) - (int) (maxSize * Math.random());
        }
        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;

        int[] arr = generateRandomArray(maxSize, maxValue);
        int random = (int) (maxSize * Math.random());
        int i = random < arr.length ? random : 0;
        printArray(arr);

        try {
            swap001(arr, i, i + 1);
        } catch (Exception e) {
            System.out.println(i);
        }
        System.out.println(i + ", " + arr[i]);
        System.out.println(i + 1 + ", " + arr[i + 1]);
    }

    /**
     * 交换函数
     *
     * @param arr 数组
     * @param i 下标1
     * @param j 下标2
     */
    public static void swap001(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
