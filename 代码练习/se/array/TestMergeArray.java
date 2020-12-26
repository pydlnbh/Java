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
        int[] oldArr1 = {1, 7, 9, 11, 13, 17, 19};
        int[] oldArr2 = {2, 4, 6, 8, 10};

        int[] newArr = concat(oldArr1, oldArr2);
        printArray(newArr);
        //　排序
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] concat(int[] arr1, int[] arr2) {
        // 创建一个长度为两个数组长度和的数组
        int[] newArray = new int[arr1.length + arr2.length];

        // 依次添加数组的值
        int count = 0;
        // 使用增强for循环
        for (int i : arr1) {
            newArray[count++] = i;
        }
        // 使用普通循环
        for (int i = 0; i < arr2.length; i++) {
            newArray[count++] = arr2[i];
        }
        return newArray;
    }

    public static void concat1(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length + arr2.length];

        // 使用System的arraycopy方法, System.arraycopy(源数组, 从源数组下标开始, 新数组, 新数组开始下标, 数组结束小标)
        System.arraycopy(arr1, 0, newArray, 0, arr1.length);
        System.arraycopy(arr2, 0, newArray, arr1.length, arr2.length);
    }

    // 打印数组
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
