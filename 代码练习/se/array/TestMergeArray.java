package com.java.se.array;

import java.util.Arrays;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestMergeArray {

    public static void main(String[] args) {
        int[] oldArr = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        int count = 0;

        for (int i = 0; i < oldArr.length; i++) {
            if (0 == oldArr[i]) {
                count++;
            }
        }

        int[] newArr = new int[oldArr.length - count];
        int size = 0;

        for (int i = 0; i < oldArr.length; i++) {
            if (0 == oldArr[i]) {
                continue;
            } else if (0 != oldArr[i]) {
                newArr[size++] = oldArr[i];
            }
        }

        printArray(newArr);
        System.out.println(Arrays.toString(newArr));
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.println(arr[i] + "]");
            }
        }
    }
}
