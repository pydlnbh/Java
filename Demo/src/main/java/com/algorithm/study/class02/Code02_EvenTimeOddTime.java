package com.algorithm.study.class02;

/**
 * 异或运算
 *
 * @author peiyiding
 * */
public class Code02_EvenTimeOddTime {

    /**
     * arr中, 只有一个数, 出现奇数次
     *
     * @param arr
     */
    public static void printOneOddTimesNum(int[] arr) {
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
    public static void printTwoOddTimesNum(int[] arr) {
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

    public static void test() {
        int num = 50;
        System.out.println("num: " + num + ", binary: " + Integer.toBinaryString(num) + ", binary have: [" + bit1Counts001(num) + "]");

        int[] arr1 = {1, 1, 1, 1, 2, 2, 2};
        int[] arr2 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        printOneOddTimesNum001(arr1);
        printTwoOddTimesNum001(arr2);
    }

    /**
     * 主方法
     *
     * @param args
     * */
    public static void main(String[] args) {
        test();
    }

    /**
     * 计算二进制中1的个数
     *
     * @param num 需要计算的数
     * @return int 返回个数
     */
    public static int bit1Counts001(int num) {
        int count = 0;
        while (num > 0) {
            int rightOne = num & (~num + 1);
            count++;
            num ^= rightOne;
        }
        return count;
    }

    /**
     * 打印出现数组中出现只出现一次奇数次的数字
     *
     * @param arr 数组
     */
    public static void printOneOddTimesNum001(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }

        System.out.println("Only one appear odd times number in an array = " + num);
    }


    /**
     * 打印出现数组中出现只出现两次奇数次的数字
     *
     * @param arr 数组
     */
    public static void printTwoOddTimesNum001(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (~eor + 1);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (0 != (arr[i] & rightOne)) {
                ans ^= arr[i];
            }
        }

        System.out.println("Only Two appear odd times number in an array, num1 = " + ans + ", num2 = " + (ans ^ rightOne));
    }

}
