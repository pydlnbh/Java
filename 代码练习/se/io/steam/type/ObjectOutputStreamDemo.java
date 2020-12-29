package com.java.se.io.steam.type;

import com.java.se.collection.Person;

import java.io.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.steam.type
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("ddd.txt");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeUTF("test");
            objectOutputStream.writeObject(new Person("测试", 122));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
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
