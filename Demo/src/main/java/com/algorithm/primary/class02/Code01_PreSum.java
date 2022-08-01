package com.algorithm.primary.class02;

import com.se.thread.test.Run;

/**
 * @author peiyiding
 * @date 2021/12/27 22:56
 * @descption 数组前缀和
 */
public class Code01_PreSum {

    public static class RangeSum1 {

        private int[] arr;

        public RangeSum1(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    public static class RangeSum2 {

        private int[] arr;

        public RangeSum2(int[] arr) {
            this.arr = new int[arr.length];
            this.arr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                this.arr[i] = this.arr[i - 1] + arr[i];
            }
        }

        public int rangeSum(int left, int right) {
            return left == 0 ? this.arr[right] : this.arr[right] - this.arr[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 8, 10};
        RangeSum1 rangeSum1 = new RangeSum1(arr);
        int i1 = rangeSum1.rangeSum(1, 3);
        System.out.println(i1);

        RangeSum2 rangeSum2 = new RangeSum2(arr);
        int i = rangeSum2.rangeSum(2, 4);
        System.out.println(i);

        RangeSum3 rangeSum3 = new RangeSum3(arr);
        int result = rangeSum3.range(2, 4);
        System.out.println(result);
    }

    public static class RangeSum3 {
        private int[] arr;

        public RangeSum3(int[] arr) {
            this.arr = new int[arr.length];
            this.arr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                this.arr[i] = this.arr[i - 1] + arr[i];
            }
        }

        public int range(int left, int right) {
            return left == 0 ? arr[right] : arr[right] - arr[left - 1];
        }
    }
}
