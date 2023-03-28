package com.algorithm.primary.class05;

import java.util.HashSet;

public class Code01_BitMap {

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

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int num = (int) (Math.random() * max);
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops1!");
                    break;
                }
            }
        }
        for (int i = 0; i <= max; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops2!");
                break;
            }
        }
        System.out.println("测试结束!");
    }
}
