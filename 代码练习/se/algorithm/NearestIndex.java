package com.java.algorithm.primary.class02;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/29
 * @Description: com.java.algorithm.primary.class02
 */
public class NearestIndex {
    // main
    public static void main(String[] args) {

    }

    // 二分法
    public static int binarySearch(int[] arr, int value) {
        // 最左侧下标
        int L = 0;
        // 最右侧下标
        int R = arr.length - 1;
        // 定义一个变量方便赋值中间值, 如果找不到为-1
        int index = -1;

        // 循环查找
        while (L <= R) {
            // 记录中间位置
            int mid = L + ((R - L) >> 2);
            if (arr[mid] > value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
