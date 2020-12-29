package com.java.se.io.test;

import java.io.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.test
 */
public class ExitTest {
    public static void main(String[] args) {
        // 字节输入流
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // 字节输出流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        // 字符输入处理流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 字符输出处理流
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        try {
            String str = "";
            while (!str.equals("exit")) {
                // 输入流读操作, 调用读一整行的方法
                str = bufferedReader.readLine();
                // 输出流写操作
                bufferedWriter.write(str);
                // 如果带flush读一行写一行, 不带最后循环退出才读, 数据还读不全
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
                outputStreamWriter.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
