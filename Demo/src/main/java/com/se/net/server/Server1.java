package com.se.net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.net.server
 */
public class Server1 {
    public static void main(String[] args) {
        try (
                // 创建一个服务器套接字, 绑定一个端口
                ServerSocket serverSocket = new ServerSocket(10000);
                // 监听连接并接受它, 这个方法可能阻塞直到它建立建立
                Socket server = serverSocket.accept();

                // 返回此套接字的输入流
                InputStream inputStream = server.getInputStream();

                // 返回此套接字的输出流
                OutputStream outputStream = server.getOutputStream();
                // 实例化一个处理流
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        ) {
            // 处理流写操作
            dataOutputStream.write("你好, 收到".getBytes());

            // 处理流读操作
            byte[] buff = new byte[1024];
            int read = inputStream.read(buff);
            System.out.println(new String(buff, 0, read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
