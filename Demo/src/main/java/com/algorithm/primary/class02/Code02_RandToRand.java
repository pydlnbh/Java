package com.algorithm.primary.class02;

/**
 * 从a ~ b 随机 到 c ~ d随机
 */
public class Code02_RandToRand {

    /**
     * 等概率返回 1 ~ 5
     *
     * @return int
     */
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 等概率返回 0 ~ 1
     *
     * @return int
     */
    public static int a() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 等概率返回 0 ~ 6
     *
     * @return int
     */
    public static int b() {
        int ans = 0;
        do {
            ans = (a() << 2) + (a() << 1) + a();
        } while (ans == 7);
        return ans;
    }

    /**
     * 等概率返回 1 ~ 7
     *
     * @return int
     */
    public static int c() {
        return b() + 1;
    }

    /**
     * 这个结构是唯一的随机机制
     */
    public static class RandomBox {
        private final int min;
        private final int max;

        public RandomBox(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int random() {
            return min + (int) (Math.random() * (max - min + 1));
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }
    }

    /**
     * 等概率返回 0 ~ 1
     *
     * @return int
     */
    public static int rand01(RandomBox randomBox) {
        int min = randomBox.min();
        int max = randomBox.max();
        int size = max - min + 1;
        boolean odd = (size & 1) != 0;
        int mid = size / 2;
        int ans = 0;
        do {
            ans = randomBox.random() - min;
        } while (odd && ans == mid);
        return ans < mid ? 0 : 1;
    }

    /**
     * 等概率返回from ~ to 范围上任何一个数
     *
     * @return int
     */
    public static int random(RandomBox randomBox, int from, int to) {
        if (from == to) {
            return from;
        }

        int range = to - from;
        int num = 1;

        while ((1 << num) - 1 < range) {
            num++;
        }

        int ans = 0;
        do {
            ans = 0;
            for (int i = 0; i < num; i++) {
                ans |= (rand01(randomBox) << i);
            }
        } while (ans > range);
        return ans + from;
    }

    /**
     * 返回[0, 1)的一个小数
     * 任意的x, x属于[0, 1), [0, x)范围上的数出现的概率由原来的x调整成x平方
     *
     * @return double
     */
    public static double xToXPower2() {
        return Math.min(Math.random(), Math.random());
    }

    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    public static int g() {
        return f4() + 1;
    }

    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

    public static int f01() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int f02() {
        int ans = 0;
        do {
            ans = f01();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    public static int f03() {
        return (f02() << 2) + (f02() << 1) + f02();
    }

    public static int f04() {
        int ans = 0;
        do {
            ans = f03();
        } while (ans >= 7);
        return ans;
    }

    public static int f05() {
        return f04() + 1;
    }

    public static int f06() {
        return Math.random() < 0.83 ? 0 : 1;
    }

    public static int f07() {
        int ans = 0;
        do {
            ans = f06();
        } while (ans == f06());
        return ans;
    }

    public static int fun01() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int fun02() {
        int ans = 0;
        do {
            ans = fun01();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    public static int fun03() {
        return (fun02() << 2) + (fun02() << 1) + fun02();
    }

    public static int fun04() {
        int ans = 0;
        do {
            ans = fun03();
        } while (ans >= 7);
        return ans;
    }

    public static int fun05() {
        return fun04() + 1;
    }

    public static void main(String[] args) {
        System.out.println("测试开始");

        int testTimes = 100000;
        int count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=============");

        count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);

        int k = 9;

        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数, 出现了" + counts[i] + "次");
        }

        System.out.println("=====================");

        count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("===================================");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数, 出现了" + counts[i] + "次");
        }

        System.out.println("===================================");

        counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int num = y();
            counts[num]++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i + "这个数, 出现了" + counts[i] + "次");
        }

        System.out.println("====================================");

        counts = new int[7];
        for (int i = 0; i < testTimes; i++) {
            counts[f01()]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数, 出现了" + counts[i] + "次");
        }

        System.out.println("====================================");

        counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            counts[fun05()]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数, 出现了" + counts[i] + "次");
        }
    }
}
