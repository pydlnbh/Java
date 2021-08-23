package com.se.array;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class Test2dArray {

    public static void main(String[] args) {
        int sum = 0;
        int[][] b = {{1, 1}, {21, 21}, {31, 32, 33}};

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                sum += b[i][j];
            }
        }

        System.out.println("Sum are " + sum);
    }
}
