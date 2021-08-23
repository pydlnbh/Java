package com.algorithm.primary.class02;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/29
 * @Description: com.java.algorithm.primary.class02
 */
public class EvenTimesOddTimes {
    // main
    public static void main(String[] args) {
        // 定义两个数
        int a = 4;
        int b = 9;

        // 交换两个数
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a + ", b = " + b);


        // 定义一个数组有一个出现奇数次的数
        int[] arr1 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 6, 6, 6, 6};

        // 打印出来出现奇数次的数
        printEvenTimeNum(arr1);

        System.out.println("============");

        // 定义一个数组有两个出现奇数次的数
        int[] arr2 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 6, 6, 6, 6};

        // 调用方法打印
        printOddTimesNum(arr2);

        int num = 4114;
        printBinary(num);
        System.out.println();
        int i = printOneCount(num);
        System.out.println(i);
    }

    // 打印一个出现奇数次的数组
    public static void printEvenTimeNum(int[] arr) {
        // 定义一个变量
        int eor = 0;

        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        // 打印
        System.out.println("奇数次的数 = " + eor);
    }

    // 数组中有两种数, 出现奇数次
    public static void printOddTimesNum(int[] arr) {
        // 定义一个变量eor
        int eor = 0;

        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        // 取出最右的1
        int rightOne = eor & (~eor + 1);

        // 定义一个变量, 用于存放最右侧都为1的数
        int onlyOne = 0;

        // 循环遍历
        for (int i = 0; i < arr.length; i++) {
            // 如果数组中的数和最右边为1的数与不为0
            if ((arr[i] & rightOne) != 0) {
                // 把最后一位不为1的数全部异或
                onlyOne ^= arr[i];
            }
        }

        // 打印
        System.out.println("最后一个二进制位为1的奇数次的数 = " + onlyOne + ",最后一个二进制位为1的奇数次的数 = " + (onlyOne ^ eor));
    }

    // 打印一个数的二进制
    public static void printBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((n & (1 << i)) == 0 ? "0" : "1");
        }
    }

    // 打印二进制1的个数
    public static int printOneCount(int n) {
        // 定义一个变量count
        int count = 0;

        // 循环
        while (n != 0) {
            int rightOne = n & ((-n) + 1);
            count++;
            n ^= rightOne;
        }

        // 返回count
        return count;
    }
}
