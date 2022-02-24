package com.algorithm.practice;

public class Solution016 {

    public static int add(int a, int b) {
        int res = a;
        while (b != 0) {
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }

    public static int minus(int a, int b) {
        return add(a, negaNum(b));
    }

    public static int negaNum(int num) {
        return add(~num, 1);
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int div(int a, int b) {
        int res = 0;
        int x = isNega(a) ? negaNum(a) : a;
        int y = isNega(b) ? negaNum(b) : b;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNega(a) ^ isNega(b) ? negaNum(res) : res;
    }

    public static boolean isNega(int num) {
        return num < 0;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negaNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(b, c)), b));
            }
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(add(2, 4));
        System.out.println(minus(4, 8));
        System.out.println(multi(12, 12));
        System.out.println(divide(-2147483648, 1));
        System.out.println(0x80000000);
        System.out.println(0x7fffffff);
    }

}
