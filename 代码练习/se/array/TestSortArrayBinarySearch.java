package com.java.se.array;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestSortArrayBinarySearch {

    public static void main(String[] args) {
        // 定义数组
        int[] arr = {3, 1, 24, 3, 55, 6, 75, 88};

        // 打印数组
        printArray(arr);
        // 排序数组
        insertSoft(arr);
        // 打印排序好的数组
        printArray(arr);
        // 打印查找数的下标
        System.out.println(binarySearch(arr, 0, arr.length - 1, 6));
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
        System.out.println();
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void insertSoft(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // test 二分法查找不能查询无序的数组和重复的数值
    public static int binarySearch(int[] arr, int front, int end, int findValue) {
        if (arr == null) {
            return -1;
        }

        if (front <= end) {
            int mid = (front + end) / 2;
            if (findValue == arr[mid]) {
                return mid;
            } else if (findValue < arr[mid]) {
                binarySearch(arr, front, mid - 1, findValue);
            } else {
                binarySearch(arr, mid + 1, end, findValue);
            }
        }
        return -1;
    }
}
