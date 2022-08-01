package com.algorithm.primary.class01;

import java.util.Arrays;

/**
 * @author peiyiding
 * @date 2021/12/23 22:57
 * @descption 排序
 */
public class Code03_Sort {

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
        // 选择排序
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 参数
     */
    public static void bubbleSort(int[] arr) {
        // 边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 冒泡排序
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 参数
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
     * @param arr 参数
     * @param i   下标i
     * @param j   下标j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr 参数
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 4, 3, 5};
//        insertionSort(arr);
//        printArray(arr);
        testSort();
    }

    public static void selectionSortDemo(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swapDemo(arr, minIndex, i);
        }
    }

    public static void bubbleSortDemo(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapDemo(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertionSortDemo(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swapDemo(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSortDemo01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swapDemo(arr, minIndex, i);
        }
    }

    public static void selectionSortDemo02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swapDemo(arr, minIndex, i);
        }
    }

    public static void selectionSortDemo03(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swapDemo(arr, minIndex, i);
        }
    }

    public static void bubbleSortDemo01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapDemo(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortDemo02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapDemo(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertionSortDemo01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swapDemo(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertionSortDemo02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swapDemo(arr, j, j + 1);
                }
            }
        }
    }

    public static void swapDemo(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void testSort() {
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 1000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copy(arr);
            Arrays.sort(arr);
//            selectionSortDemo(copyArray);
//            selectionSortDemo01(copyArray);
//            selectionSortDemo02(copyArray);
            selectionSortDemo03(copyArray);
//            bubbleSortDemo(copyArray);
//            bubbleSortDemo01(copyArray);
//            bubbleSortDemo02(copyArray);
//            insertionSortDemo(copyArray);
//            insertionSortDemo01(copyArray);
//            insertionSortDemo02(copyArray);
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }

    private static boolean isEqual(int[] arr, int[] copyArray) {
        if ((arr == null && copyArray != null) || (arr != null && copyArray == null)) {
            return false;
        }
        if (arr == null && copyArray == null) {
            return true;
        }
        if (arr.length != copyArray.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copyArray[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] copy(int[] arr) {
        int[] copyArray = new int[arr.length];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = arr[i];
        }
        return copyArray;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random());
        }
        return arr;
    }
}
