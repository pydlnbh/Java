package com.algorithm.practice;

/**
 * @author peiyiding
 * @date 2021/12/27 23:49
 * @descption 数组前缀和练习
 */
public class Solution005 {

    public static class PreSum01 {

        private int[] arr;

        public PreSum01(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum01(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    public static class PreSum02 {

        private int[] arr;

        public PreSum02(int[] arr) {
            this.arr = new int[arr.length];
            this.arr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                this.arr[i] = this.arr[i - 1] + arr[i];
            }
        }

        public int rangeSum(int left, int right) {
            return left == 0 ? arr[right] : arr[right] - arr[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 12, 52, 1};
        PreSum01 preSum01 = new PreSum01(arr);
        int sum01 = preSum01.rangeSum01(2, 4);
        System.out.println(sum01);

        PreSum02 preSum02 = new PreSum02(arr);
        int sum02 = preSum02.rangeSum(2, 4);
        System.out.println(sum02);
    }
}
