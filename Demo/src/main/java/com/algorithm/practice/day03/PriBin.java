package com.algorithm.practice.day03;

public class PriBin {
    public static void main(String[] args) {
        int num = 4;
        priBin(num);
    }

    /**
     * 打印数字二进制
     *
     * @param num
     */
    private static void priBin(int num) {
        // 从31位向下遍历, 0 ~ 31, int类型最大长度是8个字节, 32位
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);    // 位运算和三位运算符打印
        }
    }
}
