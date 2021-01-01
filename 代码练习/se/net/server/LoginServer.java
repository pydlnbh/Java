package com.java.se.net.server;

import com.java.se.net.client.User;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.server
 */
public class LoginServer {
    public static void main(String[] args) {
        // 使用try-with-resources
        try (
                // 创建一个服务器端口, 绑定指定的端口
                ServerSocket serverSocket = new ServerSocket(10000);
                // 监听要建立到此套接字的连接并接受它。
                Socket server = serverSocket.accept();
                // 返回此套接字的输入流
                InputStream inputStream = server.getInputStream();
                // 使用对象节点流
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                // 使用数据节点流给客户端响应
                DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream())
        ) {
            // 对象节点流读操作
            User user = (User) objectInputStream.readObject();

            // 判断是否登录成功
            String str = "";
            if ("pyd".equals(user.getName()) && "nbh".equals(user.getPassword())) {
                System.out.println("欢迎您" + user.getName());
                str = "登录成功";
            } else {
                str = "登录失败";
            }
            // 截断输入流
            server.shutdownInput();

            // 给客户端响应
            dataOutputStream.writeUTF(str);
            // 截断输出流
            server.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
