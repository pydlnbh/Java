package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.enetity
 * @Version: 1.0
 */
public class Calculation {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int times(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (0 == b) {
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        int add = calculation.add(1, 2);
        int sub = calculation.sub(32423, 2123);
        int times = calculation.times(21312, 1231);
        int div = calculation.div(12313, 21);
        int div1 = calculation.div(12, 0);
        System.out.println(div1);
        System.out.println("Results are " + add + ", " + sub + ", " + times + ", " + div);
    }
}
