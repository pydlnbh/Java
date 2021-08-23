package com.se.net.server;

import com.se.net.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.server
 */
public class LoginServerThread implements Runnable{
    // 成员遍历
    private Socket socket;

    public LoginServerThread() {}

    // 有参的构造方法
    public LoginServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 初始化对象处理流对象
        ObjectInputStream objectInputStream = null;
        // 初始化数据处理流对象
        DataOutputStream dataOutputStream = null;
        try {
            // 实例化对象流对象
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 读操作
            User user = (User) objectInputStream.readObject();

            // 判断是否登录成功
            String str = "";
            if ("pyd".equals(user.getName()) && "nbh".equals(user.getPassword())) {
                System.out.println("欢迎您," + user.getName());
                str = "登陆成功";
            } else {
                str = "登陆失败";
            }
            // 截断输入流
            socket.shutdownInput();

            // 实例化数据流对象, 把socket的输出流返回值作为构造参数
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            // 将判断结果字符串写入输出流
            dataOutputStream.writeUTF(str);
            // 截断输出流
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
                objectInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
