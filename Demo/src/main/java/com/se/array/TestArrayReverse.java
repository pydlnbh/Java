package com.se.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestArrayReverse {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input random digit: ");
        int inputNumber = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * inputNumber);
        }
        int[] arr1 = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }

        System.out.print("The original array is ");
        printArray(arr1);
        System.out.println("After the change of the array is " + Arrays.toString(arr));
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}
