package com.se.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class TestArrayRandom {

    public static void main(String[] args) {

        int[] arr = new int[50];
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input random range: ");
        int inputNumber = sc.nextInt();

        for (int i = 0; i < 50; i++) {
            arr[i] = random(inputNumber);
        }

        int max = arr[0];
        int min = max;
        int count = 0;

        for (int j = 0; j < 50; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
            if (arr[j] < min) {
                min = arr[j];
            }
            if (60 < arr[j]) {
                count++;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("Max is " + max + ", Min is " + min + ", The number of more than 60 are " + count);
    }

    public static int random(int n) {
        int num = (int) (Math.random() * n);
        return num;
    }
}
