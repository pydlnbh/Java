package com.algorithm.primary.class01;

/**
 * @author peiyiding
 * @date 2021/12/23 22:57
 * @descption 阶乘之和
 */
public class Code02_SumOfFactorial {

    public static void main(String[] args) {
        int num = 3;
        long f1 = f1(num);
        long f2 = f2(num);
        long f3 = factorialPractice(num);
        System.out.println("f1 = " + f1 + ", f2 = " + f2);
        System.out.println(f3);
        System.out.println(factorialDemo(num));
    }

    public static long f1(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static long f2(int n) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur *= i;
            ans += cur;
        }
        return ans;
    }

    /**
     * num阶乘之和
     * @param num 数值
     * @return int
     */
    public static int factorialPractice(int num) {
        int res = 0;
        int cur = 1;
        for (int i = 1; i <= num; i++) {
            cur *= i;
            res += cur;
        }
        return res;
    }


    public static int factorialDemo(int num) {
        int res = 0;
        int ans = 1;
        for (int i = 1; i <= num; i++) {
            ans *= i;
            res += ans;
        }
        return res;
    }
}
