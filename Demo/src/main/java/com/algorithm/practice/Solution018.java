package com.algorithm.practice;

public class Solution018 {

    /**
     * 实现前缀和数组
     */
    public static class preSum {
        private int[] arr;

        public preSum(int[] arr) {
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

    /**
     * 如何用1~5的随机函数加工出1~7的随机函数
     */
    public static class randomBox {
        public int f() {
            // [0, 1) * 5 -> [0, 5) + 1 -> (int) [1, 6) -> [1, 5]
            return (int) (Math.random() * 5) + 1;
        }

        public int f1() {
            int ans = 0;
            do {
                ans = f();
            } while (ans == 3);
            return ans > 3 ? 0 : 1;
        }

        public int f2() {
            return (f1() << 2) + (f1() << 1) + f1();
        }

        public int g() {
            return f2();
        }
    }

    /**
     * 如何用a~b的随机函数加工出c~d的随机函数
     * 例: 3 ~ 9 -> 5 ~ 20
     */
    public static class RandomBox1 {
        public int f() {
            return (int) (Math.random() * 7) + 3;
        }

        public int f1() {
            int ans = 0;
            do {
                ans = f();
            } while (ans == 6);
            return ans > 6 ? 0 : 1;
        }

        public int f2() {
            return (f1() << 4) + (f1() << 3) + (f1() << 2) + (f1() << 1) + f1();
        }

        public int f3() {
            int ans = 0;
            do {
                ans = f2();
            } while (ans > 15);
            return ans;
        }

        public int g() {
            return f3() + 5;
        }
    }

    /**
     * 如何把不等概率随机函数变成等概率随机函数
     */
    public static class RandomBox2 {
        public int f() {
            return Math.random() < 0.21 ? 0 : 1;
        }

        public int g() {
            int ans = 0;
            do {
                ans = f();
            } while (ans == f());
            return ans;
        }
    }

    /**
     * 测试前缀和数组
     */
    private static void testPreSum() {
        int testSum = 0;
        int left = 2;
        int right = 4;
        int[] arr = {2, 12, 213, 12, 23, 1};
        int sum = new preSum(arr).rangeSum(left, right);
        for (int i = left; i <= right; i++) {
            testSum += arr[i];
        }
        System.out.println(sum == testSum);
    }

    /**
     * 实现1~5的随机函数加工出1~7的随机函数
     */
    public static void testRandom() {
        int testTimes = 10000;
        int num = 8;
        int[] counts = new int[num];
        for (int i = 0; i < testTimes; i++) {
            counts[new randomBox().g()]++;
        }
        for (int j = 1; j < num; j++) {
            System.out.println(j + "这个数出现了: " + counts[j] + "次!");
        }
    }

    /**
     * 实现a~b的随机函数加工出c~d的随机函数
     */
    public static void testRandom1() {
        int num = 31;
        int testTimes = 100000;
        int[] counts = new int[num];
        for (int i = 0; i < testTimes; i++) {
            counts[new RandomBox1().g()]++;
        }
        for (int i = 0; i < num; i++) {
            System.out.println(i + "这个数出现了: " + counts[i] + "次!");
        }
    }

    /**
     * 实现把不等概率随机函数变成等概率随机函数
     */
    public static void testRandom2() {
        int num = 2;
        int testTimes = 100000;
        int[] counts = new int[num];
        for (int i = 0; i < testTimes; i++) {
            counts[new RandomBox2().g()]++;
        }
        for (int i = 0; i < num; i++) {
            System.out.println(i + "这个数出现了: " + counts[i] + "次!");
        }
    }

    /**
     * 主方法
     *
     * @param args 参数
     */
    public static void main(String[] args) {
//        testPreSum();
//        testRandom();
//        testRandom1();
        testRandom2();
    }
}
