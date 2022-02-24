package com.algorithm.practice;

public class Solution015 {

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

    public static class BitMap01 {

        private long[] bits;

        public BitMap01(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean containKey(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {

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

        public boolean containNum(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }




















}
