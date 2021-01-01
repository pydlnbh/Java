package com.java.se.net.server;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.server
 */
public class PicServer {
    public static void main(String[] args) {
        // 使用try-with-resources关闭io流对象
        try (
                // 创建服务器端对象, 开放端口
                ServerSocket serverSocket = new ServerSocket(10086);
                // 创建服务端的socket
                Socket server = serverSocket.accept();
                // 获取输入流对象
                InputStream inputStream = server.getInputStream();
                // 创建文件输出流的对象
                FileOutputStream fileOutputStream = new FileOutputStream("03.jpg");
                // 获取输入流对象
                OutputStream outputStream = server.getOutputStream();
        ) {
            // 循环读写操作
            int read = 0;
            while ((read = inputStream.read()) != -1) {
                fileOutputStream.write(read);
            }
            // 手动关闭输入流
            server.shutdownInput();

            // 上传图片成功后返回信息
            outputStream.write("传输成功".getBytes());
            // 手动关闭输出流
            server.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
