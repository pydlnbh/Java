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

    public static class PreSum03 {

        private int[] arr;

        public PreSum03(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum02(int left, int right) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                res += arr[i];
            }
            return res;
        }
    }

    public static class PreSum04 {

        private int[] arr;

        public PreSum04(int[] arr) {
            this.arr = new int[arr.length];
            this.arr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                this.arr[i] = this.arr[i - 1] + arr[i];
            }
        }

        public int range04(int left, int right) {
            return left == 0 ? arr[right] : arr[right] - arr[left - 1];
        }
    }

    public static class PreSum06 {
        private int[] arr;

        public PreSum06(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int left, int right) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                res += arr[i];
            }
            return res;
        }
    }

    public static class PreSum07 {
        private int[] arr;

        public PreSum07(int[] arr) {
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

    public static class PreSum08 {
        private int[] arr;

        public PreSum08(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int left, int right) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                res += arr[i];
            }
            return res;
        }
    }

    public static class PreSum09 {
        private int[] arr;

        public PreSum09(int[] arr) {
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
        PreSum08 preSum01 = new PreSum08(arr);
        int sum01 = preSum01.rangeSum(2, 4);
        System.out.println(sum01);

        PreSum09 preSum02 = new PreSum09(arr);
        int sum02 = preSum02.rangeSum(2, 4);
        System.out.println(sum02);
    }
}
