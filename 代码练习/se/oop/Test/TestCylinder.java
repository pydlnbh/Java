package com.java.se.oop.Test;

import com.java.se.oop.entity.Cylinder;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 */
public class TestCylinder {

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(4, 5);
        cylinder.showVolume();
    }
}
