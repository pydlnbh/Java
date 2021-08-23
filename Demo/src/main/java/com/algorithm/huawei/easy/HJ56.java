package com.algorithm.huawei.easy;

import java.util.Scanner;

/**
 * 完全数计算
 */
public class HJ56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            for (int i = 2; i <=num; i++) {
                if (isPerfactNum(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isPerfactNum(int num) {
        int sum = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum + 1 == num) {
            return true;
        }

        return false;
    }
}
