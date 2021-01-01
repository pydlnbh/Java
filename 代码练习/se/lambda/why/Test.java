package com.java.se.lambda.why;

import java.util.ArrayList;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.why
 */
public class Test {
    // main
    public static void main(String[] args) {
        // 实例化ArrayList对象
        ArrayList<Student> list = new ArrayList<>();
        // 添加属性
        list.add(new Student("zs", 12, 55));
        list.add(new Student("ls", 72, 76));
        list.add(new Student("ww", 52, 45));
        list.add(new Student("zl", 22, 89));
        list.add(new Student("hq", 42, 25));

        // 查询年龄大于20的学生
        findByAge(list);

        // 空行分隔
        System.out.println("");

        // 查询分数大于50的学生
        findByScore(list);
    }

    private static void findByScore(ArrayList<Student> list) {
        // 实例化ArrayList对象
        ArrayList<Student> students = new ArrayList<>();

        // 循环遍历添加年龄
        for (Student student : list) {
            if (student.getScore() > 50) {
                students.add(student);
            }
        }

        // 循环遍历输出
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void findByAge(ArrayList<Student> list) {
        // 实例化ArrayList对象
        ArrayList<Student> students = new ArrayList<>();

        // 循环遍历添加年龄
        for (Student student : list) {
            if (student.getAge() > 20) {
                students.add(student);
            }
        }

        // 循环遍历输出
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
