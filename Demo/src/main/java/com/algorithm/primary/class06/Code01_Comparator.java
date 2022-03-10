package com.algorithm.primary.class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 用code展示比较器的使用
 */
public class Code01_Comparator {

    public static class Student {
        private String name;
        private int id;
        private int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return -1;
            } else if (o1.id > o2.id) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age) {
                return -1;
            } else if (o1.age == o2.age) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println("{" + students[i].id + "、" + students[i].name + "、" + students[i].age + "} ");
        }
        System.out.println();
    }

    private static void printArrayList(ArrayList<Student> stuList) {
        for (Student s : stuList) {
            System.out.println("{" + s.id + "、" + s.name + "、" + s.age + "} ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 12, 3, 1, 12, 12, 32, 112, 3, 1, 3, 1, 21};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        System.out.println();

        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);

        Student[] students = {s1, s2, s3, s4, s5};
        printStudents(students);
        System.out.println();
        // 按id升序排列
        Arrays.sort(students, new IdComparator());
        printStudents(students);
        System.out.println();

        // 按age升序排列
        Arrays.sort(students, new AgeComparator());
        printStudents(students);
        System.out.println();

        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);
        stuList.add(s5);
        printArrayList(stuList);
        System.out.println();
        // 按age升序排列
        stuList.sort(new AgeComparator());
        printArrayList(stuList);

        String str1 = "cdc";
        String str2 = "csc";
        System.out.println(str1.compareTo(str2));
        System.out.println();

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println("{" + s.id + "、" + s.name + "、" + s.age + "}");
        }
    }
}
