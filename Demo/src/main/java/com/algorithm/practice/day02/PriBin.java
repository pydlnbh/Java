package com.algorithm.practice.day02;

/**
 * 打印二进制
 *
 * @author peiyiding
 * */
public class PriBin {
    public static void main(String[] args) {
        int num = 5;    // 需要打印的二进制
        priBin(num);    // 调用打印二进制的方法
    }

    /**
     * 打印二进制数组方法
     *
     * @param num
     * */
    private static void priBin(int num) {
        // 循环遍历, 8个字节(0~31) ****末尾循环体必须是i--, 不能喜欢性写为i++****
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);  // 使用三位运算符和位运算, 从高位到地位一个一个打印
        }
    }
}
