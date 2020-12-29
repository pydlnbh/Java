package com.java.se.io.test;

import java.io.*;
import java.net.URL;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.test
 */
public class NetworkTest {
    public static void main(String[] args) {
        // 初始化缓冲字符输入流
        BufferedReader bufferedReader = null;
        // 初始化缓冲字符输出流
        BufferedWriter bufferedWriter = null;
        try {
            // 实例化缓冲字符输入流
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf8"));
            // 实例化缓冲字符输出流
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));

            // 循环判断输入流读操作不为空, 就循环执行输出流写操作
            String msg = null;
            while ((msg = bufferedReader.readLine()) != null) {
                bufferedWriter.write(msg);
                // 刷新缓冲区
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
