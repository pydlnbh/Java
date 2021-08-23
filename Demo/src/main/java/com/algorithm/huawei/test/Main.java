package com.algorithm.huawei.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] s = str.split(",");
        int[] arr = new int[s.length];
        int[] arr2 = new int[s.length];
        ArrayList list = new ArrayList();

        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        sort(arr);


        list.add(arr[0] + arr[1] + arr[2]);
        list.add(arr[1] + arr[2] + arr[0]);
        list.add(arr[2] + arr[1] + arr[0]);

    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 3) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}