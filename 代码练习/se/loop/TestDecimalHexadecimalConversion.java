package com.java.se.loop;

import java.util.Scanner;

/**
 * @author PeiYiDing
 * @date 2020/12/23 23:05
 */
public class TestDecimalHexadecimalConversion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a decimal: ");
        double decimal1 = scanner.nextDouble();
        double decimal2 = decimal1;
        StringBuffer buffer = new StringBuffer("0.");
        int count = 0;

        if (decimal1 >= 0 && decimal1 < 1) {
            do {
                double result = decimal1 * 2;
                int binaryBit = (int) result;
                buffer.append(binaryBit);
                count++;

                if (count > 7) {
                    break;
                }
                decimal1 = result - binaryBit;
            } while (decimal1 != 0);
        } else {
            System.out.println("Input error, please input again");
        }

        System.out.println(decimal2 + " convert to binary is " + buffer);
    }
}
