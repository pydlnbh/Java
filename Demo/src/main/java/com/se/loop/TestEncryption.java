package com.se.loop;

import java.util.Scanner;

/**
 * Encryption Rules:(Four digits)
 * 1. Each digit add 5
 * 2. Four digits and the remainder of a divided by 10 instead of the number
 * 3. First digit and 4 digit exchange
 * 4. Second digit and 3 digit exchange
 *
 * @author PeiYiDing
 * @date 2020/12/23 16:33
 */
public class TestEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number: ");
        int number = sc.nextInt();
        int d0 = number % 10;
        int d1 = (number / 10) % 10;
        int d2 = (number / 100) % 10;
        int d3 = number / 1000;
//        System.out.println(d0);
//        System.out.println(d1);
//        System.out.println(d2);
//        System.out.println(d3);
        int EncryptionNumberD0 = (d0 + 5) % 10;
        int EncryptionNumberD1 = (d1 + 5) % 10;
        int EncryptionNumberD2 = (d2 + 5) % 10;
        int EncryptionNumberD3 = (d3 + 5) % 10;
        swap(EncryptionNumberD0, EncryptionNumberD3);
        swap(EncryptionNumberD1, EncryptionNumberD2);
//        System.out.println(EncryptionNumberD0);
//        System.out.println(EncryptionNumberD1);
//        System.out.println(EncryptionNumberD2);
//        System.out.println(EncryptionNumberD3);
        System.out.println((EncryptionNumberD0 * 1000) + (EncryptionNumberD1 * 100) + (EncryptionNumberD2 * 10) + EncryptionNumberD3);
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
