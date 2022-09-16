package com.algorithm.study.practice;

import java.util.Arrays;

public class Solution001 {

    public static void main(String[] args) {
//        printBinary(4);
//        factorialSum(4);
//        testSort();
//        testPreSum();
        testRandom();
    }

    /**
     * 打印int整型二进制
     *
     * @param num 数值
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((num >> i) & 1) == 0 ? 0 : 1);
        }
    }

    /**
     * 阶乘之和
     *
     * @param num 数值
     */
    public static void factorialSum(int num) {
        int res = 0;
        int sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
            res += sum;
        }
        System.out.println(res);
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                index = arr[j] < arr[index] ? j : index;
            }
            swap(arr, index, i);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
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

    /**
     * 插入排序
     *
     * @param arr 数组
     */
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

    /**
     * 交换方法
     *
     * @param arr 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 排序对数器
     */
    public static void testSort() {
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArr = copyArray(arr);
            Arrays.sort(arr);
            selectionSort(copyArr);
//            bubbleSort(copyArr);
//            insertionSort(copyArr);
            if (!isEqual(arr, copyArr)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "yes" : "no");
    }

    /**
     * 生成随机数组
     *
     * @param maxSize 最大数组大小
     * @param maxValue 最大数组数值
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 备份数组
     *
     * @param arr 数组
     * @return int[]
     */
    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 数组
     * @param arr2 数组
     * @return boolean
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr1 != null) || (arr1 != null && arr2 == null)) {
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

    /**
     * 数组前缀和
     */
    public static class PreSum {
        private int[] array;

        public PreSum(int[] arr) {
            array = new int[arr.length];
            array[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                array[i] = arr[i] + array[i - 1];
            }
        }

        public int range(int left, int right) {
            return left == 0 ? array[right] : array[right] - array[left - 1];
        }
    }

    public static void testPreSum() {
        int[] arr = {2, 3, 4, 5, 6};
        PreSum preSum = new PreSum(arr);
        int range = preSum.range(1, 3);
        System.out.println(range);
    }

    /**
     * 4~16随机到1~8随机
     */
    public static class Random {

        public static int f() {
            return (int) (Math.random() * 10) + 6;
        }

        // 4 5 6 7 8 9 10 11 12 13 14 15 16
        public static int f01() {
            int ans = 0;
            do {
                ans = f();
            } while (ans == 10);
            return ans < 10 ? 0 : 1;
        }

        public static int f02() {
            return (f01() << 4) + (f01() << 3) + (f01() << 2) + (f01() << 1) + f01();
        }

        public static int f03() {
            int ans = 0;
            do {
                ans = f02();
            } while (ans > 7);
            return ans;
        }

        public static int g() {
            return f03() + 1;
        }

        public void test() {
            int testTimes = 10000;
            int count = 18;
            int[] arr = new int[count];
            for (int i = 0; i < testTimes; i++) {
                arr[f()]++;
            }
            for (int i = 0; i < count; i++) {
                System.out.println(i + "出现了" + arr[i]);
            }
        }
    }

    public static void testRandom() {
        Random random = new Random();
        random.test();
    }

}
