package com.algorithm.study.practice;

public class Solution003 {

    public static void main(String[] args) {
        System.out.println(add02(1, 2));
        System.out.println(sub(1, 2));
        System.out.println(mul(2, 2));
        System.out.println(div(4, 2));
    }

    public static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contain(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int add01(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int add02(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int sub(int a, int b) {
        return add02(a, add02(~b, 1));
    }

    public static int mul(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add02(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    public static int div(int a, int b) {
        int x = isNega(a) ? nega(a) : a;
        int y = isNega(b) ? nega(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = sub(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = sub(x, y << i);
            }
        }
        return isNega(a) ^ isNega(b) ? nega(res) : res;
    }

    public static boolean isNega(int num) {
        return num < 0;
    }

    public static int nega(int num) {
        return add02(~num, 1);
    }

    public static int divide(int a, int b) {
        if (a == Integer.MAX_VALUE && b == Integer.MAX_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == nega(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add02(a, 1), b);
                return add02(c, div(sub(a, mul(b, c)), b));
            }
        } else if (b == 0) {
            return 0;
        } else {
            return div(a, b);
        }
    }

}
