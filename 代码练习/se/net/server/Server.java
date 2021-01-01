package com.java.se.net.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.net.server
 */
public class Server {
    public static void main(String[] args) {

        try (
                // 创建一个服务器套接字, 绑定到指定的端口
                ServerSocket serverSocket = new ServerSocket(10086);
                // 监听一个套接字连接并接受它, 这个方法会阻塞直到建立连接
                Socket server = serverSocket.accept();
                // 返回此套接字的输入流
                InputStream inputStream = server.getInputStream();
                // 处理流(包装流)
                DataInputStream dataInputStream = new DataInputStream(inputStream);
        ) {
            // 输入流读字符串方法
            String s = dataInputStream.readUTF();
            // 打印
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
