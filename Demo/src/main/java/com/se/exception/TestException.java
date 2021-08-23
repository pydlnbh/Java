package com.se.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.exception
 */
public class TestException {

    public static void main(String[] args) throws MyException {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您要选择的课程号: ");

        try {
            int i = sc.nextInt();
            if (0 == i) {
                System.out.println("Java");
            } else if (1 == i) {
                System.out.println("Scala");
            } else {
                System.out.println("Python");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("选课失败");
        } finally {
            MyException myException = new MyException("my");
        }
    }
}
