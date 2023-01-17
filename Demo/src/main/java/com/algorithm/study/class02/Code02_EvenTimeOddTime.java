package com.algorithm.study.class02;

/**
 * 异或运算
 *
 * @author James
 * */
public class Code02_EvenTimeOddTime {

    /**
     * arr中, 只有一个数, 出现奇数次
     *
     * @param arr
     */
    public static void printOddTimeNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * arr中, 有两种数, 出现奇数次
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (-eor);

        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 计算一个数字二进制形式有几个1
     *
     * @param N
     * */
    public static int bit1counts(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & ((~N) + 1); // N & (-N)
            count++;
            N ^= rightOne;
        }
        return count;
    }

    /**
     * 主方法
     *
     * @param args
     * */
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 2, 2, 2};
        int[] arr2 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        printOddTimeNum1(arr1);
        printOddTimesNum2(arr2);

        System.out.println(Integer.toBinaryString(12));
        System.out.println(bit1counts(12));
    }
}
