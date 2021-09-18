package com.algorithm.practice;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution002 {
    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 10;

        int[] source = generateRandomArray(maxSize, maxValue);
        int[] result = Arrays.stream(source).distinct().sorted().toArray();
        System.out.println(Arrays.toString(result));

        int num = result[(int) ((result.length + 1) * Math.random())];

        boolean flag = exist(result, num);
        System.out.println(flag);
    }

    private static boolean exist(int[] result, int num) {
        int begin = 0;
        int end = result.length - 1;
        int mid = 0;

        while (begin < end) {
            mid = begin + ((end - begin) >> 1);
            if (result[mid] == num) {
                System.out.println(mid + "--->" + result[mid]);
                return true;
            } else if (result[mid] < num) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }


    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return int[]
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }
}
