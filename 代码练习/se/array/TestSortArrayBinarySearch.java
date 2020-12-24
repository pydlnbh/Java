package com.java.se.array;

import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestSortArrayBinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please input random range: ");
        int inputValue = sc.nextInt();
        int[] arr = new int[random(inputValue / 2)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random(inputValue);
        }

        printArray(arr);
        insertSoft(arr);
        printArray(arr);
        binarySearch(arr, 12);
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

    public static int random(int num) {
        return (int) (Math.random() * num);
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

    public static int binarySearch(int[] arr, int num) {
        if (num == -1) {
            return 0;
        }

//        return binarySearch(num);
        return 0;
    }
}
