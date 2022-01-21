package com.develop.manual.question13;

import cn.hutool.core.io.IoUtil;
import org.aspectj.util.FileUtil;
import org.springframework.util.FileSystemUtils;

import java.io.*;

public class SerializableDemo1 {

    public static void main(String[] args) {
        File file = new File("src/main/java/com/develop/manual/question13/tempFile");

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtil.close(ois);
        }
    }
}
