package com.java.algorithm.practice.class02;

import java.util.Arrays;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.algorithm.practice.class02
 */
public class TwoNumberExist {
    // for main
    public static void main(String[] args) {
        // 定义数组
        int[] ints = {3, 2, 54, 2, 1, 74};

        // 排序
        Arrays.sort(ints);
        // 调用exist方法
        System.out.println(exist(ints, 1));
    }

    // 判断数字num在数组中是否存在
    public static boolean exist(int[] sortedArr, int num) {
        // 如果数组等于空或者数组长度等于0返回false
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        // 定义变量
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;

        // L...R
        while (L < R) {
            // (R - L) >> 1 防止数值溢出整型范围, 右移一位表示除以2
            mid = L + ((R - L) >> 1);

            // 如果数组最中间的值等于num返回true
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        // 如果有次数用用左中右任一数组下标都可以判断相等
        return sortedArr[mid] == num;
    }
}
