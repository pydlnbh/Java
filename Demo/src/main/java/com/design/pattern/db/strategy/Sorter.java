package com.design.pattern.db.strategy;

public class Sorter<T> {

    // 选择排序
    public void SelectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            }

            swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public void BubbleSort(Cat[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].comparator(arr[j + 1]) == 1) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 插入排序
    public void InsertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) { // 这里是>=大于等于, 必须有等于
                if (comparator.compara(arr[j], arr[j + 1]) == 1) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(Cat[] arr, int i, int j) {
        Cat tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
