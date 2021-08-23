package com.se.io.handlerStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.handlerStream
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        // BufferedWriter(Writer out)
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("aaa.txt"));
            bufferedWriter.write("jsdkafjh");
            bufferedWriter.newLine();
            bufferedWriter.append("测试");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
