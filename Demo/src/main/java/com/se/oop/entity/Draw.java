package com.se.oop.entity;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.entity
 * @Version: 1.0
 */
public class Draw {
    private int count, lines;

    public Draw() {

    }

    public Draw(int count, int lines) {
        this.count = count;
        this.lines = lines;
    }

    // Print Triangle
    public void drawTrial() {
        for (int i = 0; i <= lines; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Print Rectangle
    public void drawRec() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Print Parallelogram
    public void drawPar() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < count; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void drawPara() {
        for (int i = lines - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < count; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
