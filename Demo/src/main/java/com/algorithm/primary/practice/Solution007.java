package com.algorithm.primary.practice;

public class Solution007 {

    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() -> double -> [0, 1)
//        double ans = Math.random();

        int testTimes = 1000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.9) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=====================================");

        // [0, 1) * 8 -> [0, 8)
//        ans = Math.random() * 8;
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 4 / 8);

        int k = 8;
        // [0, k) - > [0, k - 1] -> [0, 8) -> [0, 7]
//        ans = (int) (Math.random() * k);
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数, 出现了" + counts[i] + "次.");
        }

        System.out.println("========================================");

        count = 0;
        double x = 0.6;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));

        System.out.println("========================================");

        count = 0;
        x = 0.3;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower3() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 3));

        System.out.println("========================================");

        count = 0;
        x = 0.3;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower4() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 4));

        System.out.println("===================================");

        count = 0;
        x = 0.4;
        for (int i = 0; i < testTimes; i++) {
            if (mathMinTest() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 1 - Math.pow((double) 1 - x, 2));

        System.out.println("===================================");

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f1() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("===================================");

        counts = new int[k];
        for (int i = 0; i < testTimes; i++) {
            counts[f2()]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }

        System.out.println("===================================");

        counts = new int[k];
        for (int i = 0; i < testTimes; i++) {
            counts[f3()]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }

        System.out.println("===================================");

        counts = new int[k];
        for (int i = 0; i < testTimes; i++) {
            counts[g()]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }

    }

    /**
     * 返回[0, 1)的一个小数
     * 任意的x, x属于[0, 1), [0, x)范围上的数出现概率由原来的x调整成x平方
     *
     * @return double
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    /**
     * 返回[0, 1)的一个小数
     * 任意的x, x属于[0, 1), [0, x)范围上的数出现概率由原来的x调整成x三次方
     *
     * @return double
     */
    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    /**
     * 返回[0, 1)的一个小数
     * 任意的x, x属于[0, 1), [0, x)范围上的数出现概率由原来的x调整成x四次方
     *
     * @return double
     */
    public static double xToXPower4() {
        return Math.max(Math.max(Math.random(), Math.random()), Math.max(Math.random(), Math.random()));
    }

    public static double mathMinTest() {
        return Math.min(Math.random(), Math.random());
    }

    /**
     * [1, 5]等概率返回
     *
     * @return int
     */
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制, 只能用f(), 等概率返回0和1
     *
     * @return int
     */
    public static int f1() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 等概率返回 0 ~ 7
     *
     * 8    4   2   1
     *
     * @return int
     */
    public static int f2() {
        return (f1() << 2) + (f1() << 1) + f1();
    }

    /**
     * 等概率返回 0 ~ 6
     *
     * @return
     */
    public static int f3() {
        int ans = 0;
        do {
            ans = f2();
        } while (ans == 7);
        return ans;
    }

    /**
     * 等概率返回 1 ~ 7
     *
     * @return int
     */
    public static int g() {
        return f3() + 1;
    }

}
