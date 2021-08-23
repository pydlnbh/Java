package com.algorithm.primary.class01;

public class PrintBinary {
    public static void main(String[] args) {
//        intBinary(4);
//        f1 (4);
//        int a = 2147483647;
        long a = 2147483648l;
        f1(a);

        System.out.println();
        f3(4);
        System.out.println();
        f4(4);
    }
    public static void intBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void f1(int num) {
        // 如果int i不是0, 是从打大小循环,末尾循环体(表达式3)是i--
        // 条件表达式(表达式2) 等于0是最后移位的判断, 因为二进制是从0开始到31, 0~31, 32位
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void f2(int num) {
        // 1000 0000  0000 0000  0000 0000  0000 0000
        // 0100 0000  0000 0000  0000 0000  0000 0000
        // 0010 0000  0000 0000  0000 0000  0000 0000
        // 0001 0000  0000 0000  0000 0000  0000 0000
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void f1(long num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
    }

    public static void f3(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? 1 : 0);
        }
    }

    public static void f4(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 1 ? 1 : 0); // false 因为等于1相当于1的二进制
        }
    }
}
