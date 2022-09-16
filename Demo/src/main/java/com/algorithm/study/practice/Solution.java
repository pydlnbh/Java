package com.algorithm.study.practice;

import java.util.Arrays;

public class Solution {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

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

    public static class PreSum {
        int[] preSum;

        public PreSum(int[] arr) {
            preSum = new int[arr.length];
            preSum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                preSum[i] = preSum[i - 1] + arr[i];
            }
        }

        public int rangeSum(int left, int right) {
            return left == 0 ? preSum[right] : preSum[right] - preSum[left - 1];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void testPreSum() {
        int[] arr = {2, 3, 5, 2, 32, 42};
        PreSum preSum = new PreSum(arr);
        int sum = preSum.rangeSum(2, 4);
        int testSum = 0;
        for (int i = 2; i <= 4; i++) {
            testSum += arr[i];
        }
        boolean flag = sum == testSum ? true : false;
        System.out.println(flag ? "yes" : "no");
    }

    /**
     * 无序相邻不相等数组二分找到局部最小值
     */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
//        if (left < right) { // 对数器测试 使用if出错 应该使用while 如下, 测试成功
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     *
     * @param arr
     */
    public static void printOddTimes(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (-eor);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                ans ^= arr[i];
            }
        }

        System.out.println("1: " + ans + ", 2: " + (ans ^ eor));
    }

    public static void printOddTimes01(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (-eor);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                ans ^= arr[i];
            }
        }

        System.out.println("1: " + ans + ", 2: " + (ans ^ eor));
    }

    public static void printOddTimes02(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (-eor);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                ans ^= arr[i];
            }
        }

        System.out.println("1: " + ans + ", 2: " + (eor ^ ans));
    }

    public static void printOddTimes03(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int rightOne = eor & (-eor);
        int ans = 0;
        for (int i : arr) {
            if ((i & rightOne) != 0) {
                ans ^= i;
            }
        }
        System.out.println("1: " + ans + ", 2: " + (ans ^ eor));
    }

    private static void testOddTimes() {
        int[] arr = {2, 2, 2, 4, 4, 4, 5, 5, 8, 8};
        printOddTimes(arr);
        printOddTimes01(arr);
        printOddTimes02(arr);
        printOddTimes03(arr);
    }

    /**
     * 输入一定能够保证，数组中所有的数都出现了M次，只有一种数出现了K次
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int km(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            help[i] %= m;
            if (help[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static int km01(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            help[i] %= m;
            if (help[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    private static int km02(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i : arr) {
            help[i] %= m;
            if (help[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static int km03(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (help[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static int km04(int[] arr, int m, int k) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (help[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static void testSort() {
        int testTimes = 10000;
        int maxSize = 1000;
        int maxValue = 1000;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr = genRanArr(maxSize, maxValue);
            int[] copyArr = copy(arr);
//            selectionSort(arr);
//            bubbleSort(arr);
//            insertionSort(arr);
//            selectionSortDemo(arr);
            selectionSortDemo01(arr);
//            bubbleSortDemo(arr);
//            insertionSortDemo(arr);
//            insertionSortDemo01(arr);
            Arrays.sort(copyArr);
            if (!isEqual(arr, copyArr)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "yes" : "no");
    }

    private static boolean isEqual(int[] arr, int[] copyArr) {
        if ((arr == null && copyArr != null) || (arr != null && copyArr == null)) {
            return false;
        }
        if (arr == null && copyArr == null) {
            return true;
        }
        if (arr.length != copyArr.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copyArr[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] copy(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static int[] genRanArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() + 1) * maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static void selectionSortDemo(int[] arr) {
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

    public static void selectionSortDemo01(int[] arr) {
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

    public static void bubbleSortDemo(int[] arr) {
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

    public static void insertionSortDemo(int[] arr) {
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

    public static void insertionSortDemo01(int[] arr) {
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

    public static void main(String[] args) {
//        testOddTimes();
        testSort();
//        testPreSum();
    }
}
