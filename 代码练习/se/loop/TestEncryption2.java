package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 17:07
 */
public class TestEncryption2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Encryption before the original: ");
        String str = sc.next();
        char[] c = str.toCharArray();
        char e = '8';
        char[] md = new char[16];
        String str1 = null;
        // Encryption
        System.out.print("Encryption is ");
        for (int i = 0; i < str.length(); i++) {
            md[i] = (char)(c[i] ^ e);
            System.out.print(md[i]);
        }
        System.out.println();
        // Decryption
        System.out.print("Decryption is ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print((char)(md[i] ^ e));
        }
    }
}
