package com.algorithm.primary.practice;

import java.util.HashSet;

public class Solution023 {

    public static int deleteDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static int deletedupcaties(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return count + 1;
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

        public boolean containNum(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void testBitMap() {
        System.out.println("测试开始");
        int max = 1000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTimes = 10000;
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
                if (bitMap.containNum(num) != set.contains(num)) {
                    System.out.println("Oops1");
                    break;
                }
            }
        }
        for (int i = 0; i <= max; i++) {
            if (bitMap.containNum(i) != set.contains(i)) {
                System.out.println("Oops2");
                break;
            }
        }
        System.out.println("测试结束");
    }

    private static void testDeleteDupcaties() {
        int[] arr = {1, 1, 2};
        int i = deletedupcaties(arr);
        System.out.println(i);
        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print(arr[i1] + " ");
        }
    }

    public static class BitMap01 {

        private long[] bits;

        public BitMap01(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void remove(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }

    public static void testBits() {
        int max = 1000;
        int testTimes = 10000;
        BitMap01 bitmap = new BitMap01(max);
        HashSet<Integer> set = new HashSet<>();
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int num = (int) (Math.random() * max);
            double decide = Math.random();
            if (decide < 0.33) {
                bitmap.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bitmap.remove(num);
                set.remove(num);
            } else {
                if (bitmap.contains(num) != set.contains(num)) {
                    System.out.println("Oops1");
                    break;
                }
            }
        }
        for (int i = 0; i <= max; i++) {
            if (bitmap.contains(i) != set.contains(i)) {
                System.out.println("Oops2");
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static class BitMap02 {

        private long[] bits;

        public BitMap02(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }

    public static void testBitM() {
        int max = 100;
        int testTimes = 10000;
        BitMap02 bitMap = new BitMap02(max);
        HashSet<Integer> set = new HashSet<>();
        System.out.println("begin");
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
        for (int i = 0; i <= max; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops2");
                break;
            }
        }
        System.out.println("end");
    }

    public static int add(int a, int b) {
        int res = a;
        while (b != 0) {
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }

    public static int mius(int a, int b) {
        return add(a, negaNum(b));
    }

    public static int negaNum(int num) {
        return add(~num, 1);
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(a, res);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return res;
    }

    public static int div(int a, int b) {
        int res = 0;
        int x = isNega(a) ? negaNum(a) : a;
        int y = isNega(b) ? negaNum(b) : b;
        for (int i = 30; i >= 0; i = mius(i, 1)) {
            if ((x >> i) >= y) {
                res |= 1 << i;
                x = mius(x, y << i);
            }
        }
        return isNega(a) ^ isNega(b) ? negaNum(res) : res;
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
                return add(c, div(mius(a, multi(b, c)), b));
            }
        } else {
            return div(a, b);
        }
    }

    public static boolean isNega(int num) {
        return num < 0;
    }

    private static void testCompute() {
        System.out.println(add(2, 8));
        System.out.println(mius(2, 8));
        System.out.println(multi(2, 8));
        System.out.println(divide(8, 2));
    }

    public static void testCompute01() {
        System.out.println(add01(12, 21));
        System.out.println(minus(33, 21));
        System.out.println(multi01(11, 11));
        System.out.println(divide(33, 11));
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }

    public static int add01(int a, int b) {
        int res = a;
        while (b != 0) {
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }

    public static int minus(int a, int b) {
        return add(a, negaNum01(b));
    }

    public static int negaNum01(int num) {
        return add(~num, 1);
    }

    public static int multi01(int a, int b) {
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

    public static int div01(int a, int b) {
        int res = 0;
        int x = isNega01(a) ? negaNum01(a) : a;
        int y = isNega01(b) ? negaNum01(b) : b;
        for (int i = 30; i >= 0; i = minus(a, 1)) {
            if ((x >> i) >= y) {
                res |= 1 << i;
                x = minus(a, y << i);
            }
        }
        return isNega01(a) ^ isNega01(b) ? negaNum01(res) : res;
    }

    public static int divide01(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negaNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div01(add01(a, 1), b);
                return add(c, div01(minus(a, multi01(b, c)), b));
            }
        } else {
            return div01(a, b);
        }
    }

    public static boolean isNega01(int num) {
        return num < 0;
    }

    public static class BitMap03 {

        private long[] bits;
        public BitMap03(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void remove(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }
    public static void testBitMap03() {
        int max = 1000;
        int testTimes = 10000;
        BitMap03 bitMap = new BitMap03(max);
        HashSet<Integer> set = new HashSet<>();
        System.out.println("begin");
        for (int i = 0; i < testTimes; i++) {
            int num = (int) (Math.random() * max);
            double decide = Math.random();
            if (decide < 0.33) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bitMap.remove(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops1");
                    break;
                }
            }
        }
        for (int i = 0; i <= max; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops2");
                break;
            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
//        testDeleteDupcaties();
//        testBitMap();
//        testBits();
//        testBitM();
//        testCompute();
//        testCompute01();
        testBitMap03();
    }
}
