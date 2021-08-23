package com.se.oop.Test;

import com.se.oop.entity.Draw;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 * @Version: 1.0
 */
public class TestDraw {
    public static void main(String[] args) {
        Draw draw = new Draw(16, 4);

        // Print triangle
        System.out.println("Print triangle: ");
        draw.drawTrial();

        System.out.println();

        // Print rectangle
        System.out.println("Print rectangle: ");
        draw.drawRec();

        System.out.println();

        // Print parallelogram
        System.out.println("Print parallelogram: ");
        draw.drawPar();

        System.out.println();

        // Print parallelogram
        System.out.println("Print parallelogram: ");
        draw.drawPara();
    }
}
