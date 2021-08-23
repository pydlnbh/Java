package com.se.lambda.why1;

import com.se.lambda.why.Student;

import java.util.ArrayList;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.why1
 */
public class Test {
    public static void main(String[] args) {
        // 实例化ArrayList对象
        ArrayList<Student> list = new ArrayList<Student>();

        // 添加属性
        list.add(new Student("zs", 12, 55));
        list.add(new Student("ls", 72, 76));
        list.add(new Student("ww", 52, 45));
        list.add(new Student("zl", 22, 89));
        list.add(new Student("hq", 42, 25));

        // 调用静态方法
        getByFilter(list, new AgeFilter());
        System.out.println();
        getByFilter(list, new ScoreFilter());
    }

    private static void getByFilter(ArrayList<Student> list, StudentFilter studentFilter) {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Student student : list) {
            if (studentFilter.compare(student)) {
                students.add(student);
            }
        }
        printStudent(students);
    }

    private static void printStudent(ArrayList<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
