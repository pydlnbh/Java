package com.java.se.lambda.why2;

import com.java.se.lambda.why.Student;
import com.java.se.lambda.why1.StudentFilter;

import java.util.ArrayList;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.why2
 */
public class Test {
    // main
    public static void main(String[] args) {
        // 实例化ArrayList对象
        ArrayList<Student> list = new ArrayList<Student>();

        // 添加属性
        list.add(new Student("zs", 12, 55));
        list.add(new Student("ls", 72, 76));
        list.add(new Student("ww", 52, 45));
        list.add(new Student("zl", 22, 89));
        list.add(new Student("hq", 42, 25));

        // 年龄大于20的
        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge() > 20;
            }
        });
        // 分隔
        System.out.println();
        // 分数大于60的
        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore() > 60;
            }
        });
    }

    // 过滤方法
    public static void getByFilter(ArrayList<Student> arrayList, StudentFilter studentFilter) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : arrayList) {
            if (studentFilter.compare(student)) {
                students.add(student);
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
