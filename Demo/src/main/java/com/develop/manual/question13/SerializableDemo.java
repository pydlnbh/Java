package com.develop.manual.question13;

import cn.hutool.core.io.IoUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setName("zs");

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/com/develop/manual/question13/tempFile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtil.close(oos);
        }
    }
}
