package com.se.oop.Test;

import com.se.oop.entity.Student;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/25
 * @Description: com.java.se.oop.Test
 * @Version: 1.0
 */
public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student(001, "zs", '男', 21, 88);
        int i = student.getsNo();
        String name = student.getName();
        System.out.println("no is " + i + ", name is " + name);
    }
}
