package com.algorithm.primary.class01;

/**
 * @author peiyiding
 * @date 2021/12/23 22:57
 * @descption 整形的十进制转二进制
 */
public class Code01_PrintBinary {

    private static final int INT_BIT = 31;

    public static void print(int num) {
        for (int i = INT_BIT; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static String binary(int num) {
        String binary = "";
        for (int i = INT_BIT; i >= 0; i--) {
            binary += (num & (1 << i)) == 0 ? "0" : "1";
        }
        return binary;
    }

    /**
     * 打印num的二进制
     *
     * @param num 数值
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        print(5);
        int num = 5;
        String binary = binary(num);
        System.out.println(num + "的二进制: " + binary);
    }
}
