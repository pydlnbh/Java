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
        printBinaryDemo(num);
        System.out.println();
        printBinaryDemo01(num);
        System.out.println();
        printBinaryDemo02(num);
        System.out.println();
        printBinaryDemo03(num);
    }

    public static void printBinaryDemo(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void printBinaryDemo01(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void printBinaryDemo02(int num) {
        for (int i = 31; i >= 0; i--) {
            int index = 1 << i;
            int indexNum = num & index;
            System.out.print(indexNum == 0 ? 0 : 1);
        }
    }

    public static void printBinaryDemo03(int num) {
        for (int i = 31; i >= 0; i--) {
            int index = 1 << i;
            int indexNum = num & index;
            if (indexNum == 0) {
                System.out.print(0);
            } else {
                System.out.print(1);
            }
        }
    }
}
