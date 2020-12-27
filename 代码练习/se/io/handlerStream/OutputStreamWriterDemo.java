package com.java.se.io.handlerStream;

import java.io.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.handlerStream
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        // 实例化文件对象
        File file = new File("abc.txt");
        // 实例化输出节点流对象
        FileOutputStream fileOutputStream = null;
        // 实例化输出处理流对象
        OutputStreamWriter outputStreamWriter = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            // 处理流可以定义字符编码类型
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write("ld到时候a");
            outputStreamWriter.write("adsfklja", 0, 5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
