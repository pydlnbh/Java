package com.algorithm.practice;

import java.util.HashSet;

public class Solution028{
    private static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        private void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        private void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        private boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    private static void test() {
        int max = 1000;
        int testTimes = 1000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int num = (int) (Math.random() * max);
            double decide = Math.random();
            if (decide < 0.33) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops1");
                    break;
                }
            }
        }
        for (int i = 0; i < max; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops2");
            }
        }
        System.out.println("测试结束");
    }

    private static int add(int a, int b) {
        int res = a;
        while (b != 0) {
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }

    private static int subtrc(int a, int b) {
        return add(a, nega(b));
    }

    private static int nega(int num) {
        return add(~num, 1);
    }

    private static int multi(int a, int b) {
        int x = isNega(a) ? nega(a) : a;
        int y = isNega(b) ? nega(b) : b;
        int res = 0;
        while (y != 0) {
            if ((y & 1) != 0) {
                res += x;
            }
            x <<= 1;
            y >>>= 1;
        }
        return isNega(a) ^ isNega(b) ? nega(res) : res;
    }

    private static boolean isNega(int num) {
        return num < 0;
    }

    private static int div(int a, int b) {
        int x = isNega(a) ? nega(a) : a;
        int y = isNega(b) ? nega(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = subtrc(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = subtrc(x, y << i);
            }
        }
        return isNega(x) ^ isNega(y) ? nega(res) : res;
    }

    private static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == nega(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(subtrc(a, multi(b, c)), b));
            }
        } else {
            return div(a, b);
        }
    }

    public static void test01() {
        System.out.println(add(2, 4));
        System.out.println(subtrc(2, 4));
        System.out.println(multi(2, 4));
        System.out.println(divide(16, 4));
    }

    public static void main(String[] args) {
//        test();
        test01();
    }
}
