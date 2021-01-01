package com.java.se.net.client;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.client
 */
public class PicClient {
    public static void main(String[] args) {
        try (
                // 创建图片的输入流对象
                FileInputStream fileInputStream = new FileInputStream("algorithm01/01.jpg");
                // 创建Socket
                Socket client = new Socket("localhost", 10086);
                // 获取输出流对象
                OutputStream outputStream = client.getOutputStream();
                // 获取输入流对象
                InputStream inputStream = client.getInputStream();
        ) {
            // 循环读写操作
            int tmp = 0;
            while ((tmp = fileInputStream.read()) != -1) {
                outputStream.write(tmp);
            }
            // 手动关闭输出流对象
            client.shutdownOutput();

            // 接受服务端的响应
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, read));
            // 手动关闭输入流
            client.shutdownInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
