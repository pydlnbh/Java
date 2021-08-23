package com.algorithm.huawei.easy;

import java.util.Scanner;

/**
 * 汽水瓶问题
 */
public class HJ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ok: while (sc.hasNext()) {
            int num = sc.nextInt();

            if (num == 0) {
                break ok;
            }

            System.out.println(num / 2);
        }
    }
}
