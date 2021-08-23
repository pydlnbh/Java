package com.se.loop;

/**
 * @author PeiYiDing
 * @date 2020/12/24 9:32
 */
public class TestOneHundredPrimeNumber {

    public static void main(String[] args) {

        System.out.print("Primer numbers are ");
        System.out.print("{ ");
        for (int i = 1; i <= 100; i++) {
            boolean flag = isPrime(i);
            if (flag) {
                System.out.print(i + " ");
            }
        }
        System.out.print("}");
    }

    public static boolean isPrime(int number) {

        boolean flag = true;

        if (number == 1) {
            flag = false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
