package com.se.array;

import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestRandomSort {

    public static void main(String[] args) {

        int[] arr = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a random range: ");
        int inputNumber = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomNumber(inputNumber);
        }

        System.out.print("The original array is ");
        print(arr);
        insertSort(arr);
        System.out.println();
        System.out.print("The sorted array is ");
        print(arr);
    }

    public static int randomNumber(int n) {
        return (int) (Math.random() * n);
    }

    public static void insertSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void print(int[] arr) {

        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
    }
}
