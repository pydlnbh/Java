package com.algorithm.practice;

import java.util.Arrays;
import java.util.HashSet;

public class Solution026 {

    public static void selectionSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, i, index);
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

    public static void bubbleSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
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

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) {
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

    public static void testSort() {
        int maxSize = 1000;
        int maxValue = 1000;
        int testTimes = 10000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArray = copyArray(arr);
            selectionSort(arr);
//            bubbleSort(arr);
//            insertionSort(arr);
            Arrays.sort(copyArray);
            if (!isEqual(arr, copyArray)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "ok" : "Oops");
    }

    public static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void testBitMap() {
        int max = 10000;
        int testTimes = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int num = (int) (Math.random() * max);
            double decide = Math.random();
            if (decide < 0.33) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops1");
                }
            }
        }
        for (int i = 1; i <= max; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops2");
            }
        }
        System.out.println("测试结束");
    }

    public static class NewAirthmetic {
        public int add(int a, int b) {
            int res = a;
            while (b != 0) {
                res = a ^ b;
                b = (a & b) << 1;
                a = res;
            }
            return res;
        }

        public int subtra(int a, int b) {
            return add(a, nega(b));
        }

        public int nega(int num) {
            return add(~num, 1);
        }

        public int multi(int a, int b) {
            int res = 0;
            int x = isNega(a) ? nega(a) : a;
            int y = isNega(b) ? nega(b) : b;
            while (y != 0) {
                if ((y & 1) != 0) {
                    res = add(res, x);
                }
                x <<= 1;
                y >>>= 1;
            }
            return isNega(a) ^ isNega(b) ? nega(res) : res;
        }

        public boolean isNega(int num) {
            return num < 0;
        }

        public int div(int a, int b) {
            int res = 0;
            int x = isNega(a) ? nega(a) : a;
            int y = isNega(b) ? nega(b) : b;
            for (int i = 31; i >= 0; i = subtra(i, 1)) {
                if ((x >> i) >= y) {
                    res |= (1 << i);
                    x = subtra(x, y << i);
                }
            }
            return isNega(a) ^ isNega(b) ? nega(res) : res;
        }

        public int divide(int a, int b) {
            int res = 0;
            if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
                return 1;
            } else if (b == Integer.MIN_VALUE) {
                return 0;
            } else if (a == Integer.MIN_VALUE) {
                if (b == nega(1)) {
                    return Integer.MAX_VALUE;
                }
                else {
                    int c = div(add(a, 1), b);
                    res = add(c, div(subtra(a, multi(b, c)), b));
                }
            } else {
                res =  div(a, b);
            }
            return res;
        }
    }

    public static void test() {
        NewAirthmetic airthmetic = new NewAirthmetic();
        System.out.println(airthmetic.add(1, 4));
        System.out.println(airthmetic.subtra(4, 2));
        System.out.println(airthmetic.multi(4, 2));
        System.out.println(airthmetic.divide(4, 2));
    }

    public static void main(String[] args) {
//        testSort();
//        testBitMap();
        test();
    }
}
