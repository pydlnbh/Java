package com.java.se.io.test;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.test
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        // 声明打印流对象
        PrintStream printStream = null;

        // 实例化对象
        printStream = new PrintStream(System.out); // System.out是一个PrintStream类型的变量
        try {
            // 打印, write可以写byte数组和整型
            printStream.write("nkjnkjg".getBytes());
            System.out.println(); // 等价于 printStream.println(); 打印流调用println方法
            // 打印流对象的println方法
            printStream.println(true);
            //
            System.out.printf("%s %d %.2f", "dfa", 12, 5212f);
            System.out.println();
            // 错误类型输出
            System.err.println("error");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printStream.close();
        }
    }
}
