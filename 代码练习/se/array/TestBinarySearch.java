package com.java.se.array;

import java.util.Arrays;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestBinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 12, 24, 36, 55, 68, 75, 88};

        binarySearch(arr, 24);
    }

    public static void binarySearch(int[] arr, int x) {
        int front = 0;
        int end = 7;
        int mid = (front + end) / 2;

        if (x <= arr[mid]) {
            end = mid - 1;
            mid = (front + end) / 2;
            if (x >= arr[mid]) {
                front = mid + 1;
                mid = (front + end) / 2;
                if (x == arr[mid]) {
                    System.out.print("The subscript is " + mid + ", x is " + x + " == " + arr[mid] + "Find success");
                } else if (x > arr[mid]) {
                    front = mid + 1;
                    if (front > end) {
                        System.out.println("Fucking fucked");
                    }
                }
            }
        }
    }
}

