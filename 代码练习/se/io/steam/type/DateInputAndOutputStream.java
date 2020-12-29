package com.java.se.io.steam.type;

import java.io.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.steam.type
 */
public class DateInputAndOutputStream {
    public static void main(String[] args) {
        File file = new File("ccc.txt");
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            // 输出流
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.write(123);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeFloat(2.21f);
            dataOutputStream.writeUTF("测试");

            // 输入流
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);
            System.out.println(dataInputStream.read());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
