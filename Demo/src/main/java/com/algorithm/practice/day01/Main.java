package com.algorithm.practice.day01;

/*
 * 对数器 + 选择, 冒泡, 插入排序
 * */
public class Main {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        int testTimes = 1;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = genRanArr(maxSize, maxValue);
            int[] arr2 = cpArr(arr1);

            priArr(arr1);
            priArr(arr2);

            selectionSort(arr1);
            insertionSort(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                priArr(arr1);
                priArr(arr2);
            } else {
                priArr(arr1);
                priArr(arr2);
            }
        }

        System.out.println(succeed ? "nice" : "fucking fucked!");
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1
        // 1 ~ N-1
        // 2 ~ N-1
        for (int i = 0; i < arr.length - 1; i++) { // i ~ N-1
            // 最小值在哪个位置上  i～n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
           return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) { // j >= 0 只能放在表达式2(条件表达式)中短路与中第一个判断中
                swap(arr, j, j + 1);
            }
        }
    }

    // 交换
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // 打印数组
    public static void priArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 生成随机数组
    public static int[] genRanArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() + 1) * maxSize];

        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) ((Math.random() + 1) * maxValue) - (int) (Math.random() * maxValue);
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }

    // 复制数组
    public static int[] cpArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        return copy;
    }

    // 比较两个数组
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) { // 注意判断
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        if (arr1 == null && arr2 == null) {
            return true;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {            // 相反判断
                return false;
            }
        }
        return true;
    }
}
