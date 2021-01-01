package com.java.se.lambda.why3;

import com.java.se.lambda.why.Student;
import com.java.se.lambda.why1.StudentFilter;

import java.util.ArrayList;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.why3
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
        list.add(new Student("hqq", 42, 25));

        // Lambda表达式
        getByFilter(list, (student) -> student.getAge() > 59);
        System.out.println();
        // Lambda表达式
        getByFilter(list, (student) -> student.getScore() > 80);
        System.out.println();
        getByFilter(list, (e) -> e.getName().length() > 2);
    }

    // 条件过滤方法
    public static void getByFilter(ArrayList<Student> arrayList, StudentFilter studentFilter) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : arrayList) {
            if (studentFilter.compare(student)) {
                students.add(student);
            }
        }

        // 循环遍历
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
