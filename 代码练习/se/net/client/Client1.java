package com.java.se.net.client;

import java.io.*;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.net.client
 */
public class Client1 {
    public static void main(String[] args) {
        try (
                // 创建客户端的套接字
                Socket client = new Socket("127.0.0.1", 10000);

                // 获取输出流对象
                OutputStream outputStream = client.getOutputStream();

                // 获取输出流对象
                InputStream inputStream = client.getInputStream();
        ) {
            // 输出流写操作
            outputStream.write("hello, server".getBytes());

            // 输入流读操作
            byte[] buff = new byte[1024];
            int length = inputStream.read(buff);
            System.out.println("服务端的响应数据是：" + new String(buff,0,length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
