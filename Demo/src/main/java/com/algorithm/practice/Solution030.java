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

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void mergeSort04(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processM(arr, 0, arr.length - 1);
    }

    public static void processM(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        processM(arr, L, M);
        processM(arr, M + 1, R);
        mergeM(arr, L, M, R);
    }

    public static void mergeM(int[] arr, int L, int M, int R) {
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

    public static void quickSort05(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processQ(arr, 0, arr.length - 1);
    }

    public static void processQ(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equals = partitionQ(arr, L, R);
        processQ(arr, L, equals[0]);
        processQ(arr, equals[1] + 1, R);
    }

    public static int[] partitionQ(int[] arr, int L, int R) {
        int index = L;
        int lessR = L - 1;
        int moerL = R;
        while (index < moerL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moerL, index);
            } else {
                index++;
            }
        }
        swap(arr, moerL, R);
        return new int[]{lessR, moerL};
    }

    public static void selectionSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = i; // 数组最小下标定义为i, 不能定义为0
            for (int j = i + 1; j < arr.length; j++) {
                index = arr[index] > arr[j] ? j : index;
            }
            swap(arr, i, index);
        }
    }

    public static void bubbleSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) { // 冒泡排序不能等于i, 否则会出现下标越界
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void mergeSort05(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeM01(arr, 0, arr.length - 1);
    }

    public static void mergeM01(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int M = L + ((R - L) >> 1);
        mergeM01(arr, L, M);
        mergeM01(arr, M + 1, R);
        merge01(arr, L, M, R);
    }


    public static void merge01(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p = L;
        int q = M + 1;
        int i = 0;
        while (p <= M && q <= R) {
            help[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
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

    public static void mergeSort06(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeM02(arr, 0, arr.length - 1);
    }

    public static void mergeM02(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int M = L + ((R - L) >> 1);
        mergeM02(arr, L, M);
        mergeM02(arr, M + 1, R);
        merge0(arr, L, M, R);
    }

    public static void merge0(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p = L;
        int q = M + 1;
        while (p <= M && q <= R) {
            help[i++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= M) {
            help[i++] = arr[p++]; // 使用辅助数组help, 而不是传入的参数
        }
        while (q <= R) {
            help[i++] = arr[q++]; // 使用辅助数组help, 而不是传入的参数
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i]; // 给传入的参数赋值
        }
    }

    public static void quickSort06(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSortRecursion(arr, 0, arr.length - 1);
    }

    public static void quickSortRecursion(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int[] equals = partition04(arr, L, R);
        quickSortRecursion(arr, L, equals[0]);
        quickSortRecursion(arr, equals[1] + 1, R);
    }

    public static int[] partition04(int[] arr, int L, int R) {
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

    public static void test() {
        int maxSize = 1000;
        int maxValue = 1000;
        int testTimes = 10000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copy(arr);
//            selectionSort(arr);
//            selectionSort01(arr);
//            bubbleSort(arr);
//            bubbleSort01(arr);
//            insertionSort(arr);
//            insertionSort01(arr);
//            mergeSort01(arr);
//            mergeSort02(arr);
//            mergeSort03(arr);
//            mergeSort04(arr);
//            mergeSort05(arr);
            mergeSort06(arr);
//            quickSort01(arr);
//            quickSort02(arr);
//            quickSort03(arr);
//            quickSort04(arr);
//            quickSort05(arr);
//            quickSort06(arr);
            Arrays.sort(copyArray);
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }
}
