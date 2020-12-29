package com.java.se.io.handlerStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.handlerStream
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // BufferedReader嵌套FileReader: BufferedReader(Reader in);
            reader = new BufferedReader(new FileReader("aaa.txt"));
            // 单个打印
            System.out.println(reader.read());
            // 打印一行
            System.out.println(reader.readLine());
            // 循环打印
            int read = 0;
            while ((read = reader.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
