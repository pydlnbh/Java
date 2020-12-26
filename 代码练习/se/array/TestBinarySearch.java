package com.java.se.array;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestBinarySearch {

    public static void main(String[] args) {
        // 定义数组
        int[] arr = {3, 12, 24, 36, 55, 68, 75, 88};

        System.out.println(binarySearch(arr, 24));
    }

    public static int binarySearch(int[] arr, int x) {
        if (arr == null) {
            return -1;
        }

        // 起始位置
        int front = 0;
        // 结束位置
        int end = arr.length;
        while (front <= end) {
            // 中间位置
            int mid = (front + end) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                front = mid + 1;
            }
        }
        // 如果走到这一步, 说明没有找到, 返回-1
        return -1;
    }

}

