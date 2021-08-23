package com.se.net.client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.net.client
 */
public class LoginClient {
    public static void main(String[] args) {
        // 使用try-with-resources
        try (
                // 创建一个Stream Socket并连接到它指定的端口和主机名上
                Socket client = new Socket("localhost", 10000);
                // 返回此socket的输入流
                InputStream inputStream = client.getInputStream();
                // 使用对象处理流包装返回此socket的输出流
                ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(client.getOutputStream());
                // 使用数据处理流包装响应服务端
                DataInputStream dataInputStream = new DataInputStream(inputStream);
        ) {
            // 实例化一个实体类
            User user = getUser();
            // 数据处理流写入数据
            ObjectOutputStream.writeObject(user);
            // 截断输出流, 因为直接在对象处理流当构造参数了,不用截断
            // client.shutdownOutput();

            // 接受响应
            String str = dataInputStream.readUTF();
            System.out.println(str);
            client.shutdownInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static User getUser() {
        // 构建一个扫描器
        Scanner sc = new Scanner(System.in);
        // 输入name
        System.out.print("Please input your name: ");
        String name = sc.next();
        // 输入密码
        System.out.print("Please input your password: ");
        String password = sc.next();
        return new User(name, password);
    }
}
