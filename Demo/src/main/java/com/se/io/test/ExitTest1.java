package com.se.io.test;

import java.io.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.test
 */
public class ExitTest1 {
    public static void main(String[] args) {
        try (// 输入节点流
             InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             // 输出节点流
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
             // 输入缓冲区处理流
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             // 输出缓冲区处理流
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);) {
            String str = "";
            while (!"exit".equals(str)) {
                // 读操作
                str = bufferedReader.readLine();
                // 写操作
                bufferedWriter.write(str);
                // 刷新输出流缓冲区, 使得读一行写一行, 而且数据完整读到输出
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
