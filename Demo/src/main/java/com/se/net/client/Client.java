package com.se.net.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/31
 * @Description: com.java.se.net
 */
public class Client {
    public static void main(String[] args) {
        try (
                // socket对象, 用于指定数据接受的IP地址和端口号
                Socket client = new Socket("localhost", 10086);

                // 输出流
                OutputStream outputStream = client.getOutputStream();

                // 处理流(包装流)
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        ) {
            // 写一段字符串
            dataOutputStream.writeUTF("this is socket demo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
