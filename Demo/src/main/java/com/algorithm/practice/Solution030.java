package com.algorithm.practice;

import java.util.Arrays;

public class Solution030 {

    public static void quickSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equals = partition(arr, L, R);
        process(arr, L, equals[0]);
        process(arr, equals[1] + 1, R);
    }

    public static int[] partition(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreL = R;
        int index = L;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR, moreL};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process01(arr, 0, arr.length - 1);
    }

    public static void process01(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copy(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
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

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int maxSize = 1000;
        int maxValue = 1000;
        int testTimes = 10000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copy(arr);
//            mergeSort01(arr);
//            mergeSort02(arr);
//            mergeSort03(arr);
//            quickSort01(arr);
//            quickSort02(arr);
//            quickSort03(arr);
            quickSort04(arr);
            Arrays.sort(copyArray);
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }

    public static void quickSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process02(arr, 0, arr.length - 1);
    }

    public static void process02(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equals = partition01(arr, L, R);
        process(arr, L, equals[0]);
        process(arr, equals[1] + 1, R);
    }

    public static int[] partition01(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreL = R;
        int index = L;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR, moreL};
    }

    public static void mergeSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process03(arr, 0, arr.length - 1);
    }

    public static void process03(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process03(arr, L, M);
        process03(arr, M + 1, R);
        merge03(arr, L, M, R);
    }

    public static void merge03(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p = L;
        int q = M + 1;
        while (p <= M && q <= R) {
            help[i++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= M) {
            help[i++] = arr[p++];
        }
        while (q <= R) {
            help[i++] = arr[q++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void mergeSort03(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process04(arr, 0, arr.length - 1);
    }

    private static void process04(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process04(arr, L, M);
        process04(arr, M + 1, R);
        merge04(arr, L, M, R);
    }

    private static void merge04(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p = L;
        int q = M + 1;
        while (p <= M && q <= R) {
            help[i++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= M) {
            help[i++] = arr[p++];
        }
        while (q <= R) {
            help[i++] = arr[q++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void quickSort03(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process05(arr, 0, arr.length - 1);
    }

    private static void process05(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equals = partition02(arr, L, R);
        process05(arr, L, equals[0]);
        process05(arr, equals[1] + 1, R);
    }

    private static int[] partition02(int[] arr, int L, int R) {
        int index = L;
        int lessR = L - 1;
        int moreL = R;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR, moreL};
    }

    public static void quickSort04(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process06(arr, 0, arr.length - 1);
    }

    public static void process06(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] quickArr = partition03(arr, L, R);
        process06(arr, L, quickArr[0]);
        process06(arr, quickArr[1] + 1, R);
    }

    public static int[] partition03(int[] arr, int L, int R) {
        int index = L;
        int lessR = L - 1;
        int moreL = R;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR, moreL};
    }
}
