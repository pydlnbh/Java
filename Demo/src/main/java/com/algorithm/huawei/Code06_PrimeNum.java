package com.algorithm.huawei;

import java.util.Scanner;

/**
 * 质数因子
 */
public class Code06_PrimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();
        long k = (long) Math.sqrt(num);

        for (int i = 2; i < k; i++) {
            while (num % i == 0) {
                System.out.println(i + " ");
                num /= i;
            }

            if (num == 1) {
                break;
            }
        }

        System.out.println(num == 1 ? "" : num + " ");
    }
}
