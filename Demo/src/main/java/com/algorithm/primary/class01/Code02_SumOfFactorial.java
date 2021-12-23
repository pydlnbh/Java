package com.algorithm.primary.class01;

/**
 * @author peiyiding
 * @date 2021/12/23 22:57
 * @descption 阶乘之和
 */
public class Code02_SumOfFactorial {

    public static void main(String[] args) {
        int num = 10;
        long f1 = f1(num);
        long f2 = f2(num);
        System.out.println("f1 = " + f1 + ", f2 = " + f2);
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
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }
}
