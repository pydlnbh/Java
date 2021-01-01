package com.java.se.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.server
 */
public class LoginServer1 {
    public static void main(String[] args) {
        ServerSocket socket = null;
        Socket server = null;
        try {
            socket = new ServerSocket(10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                // 监听一个连接并同意它
                server = socket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 实例化线程类
            LoginServerThread loginServerThread = new LoginServerThread(server);
            // 实例化线程
            Thread thread = new Thread(loginServerThread);
            thread.start();
        }
    }
}
