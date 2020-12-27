package com.java.se.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.utils
 */
public class ArraysDemo {
    // 主方法
    public static void main(String[] args) {
        // 使用Arrays工具类把数组转换为List
        int[] arr = {1, 2, 5, 3};
        // List<int[]> ints = Arrays.asList(arr);
        List<Integer> ints = Arrays.asList(1, 2, 5, 3);
        System.out.println(ints);

        // 数组
        Object[] objects = ints.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
