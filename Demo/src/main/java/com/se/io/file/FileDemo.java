package com.se.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.file
 */
public class FileDemo {
    // 主入口
    public static void main(String[] args) {
        File file = new File("abc.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("1 " + file.isFile());
        System.out.println("2 " + file.getAbsolutePath());
        System.out.println("3 " + file.exists());
        System.out.println("4 " + file.isDirectory());
        System.out.println("5 " + file.canExecute());
        System.out.println("6 " + file.canRead());
        System.out.println("7 " + file.canWrite());
        System.out.println("8 " + file.getName());
        System.out.println("9 " + file.isFile());
        try {
            System.out.println("10 " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("11 " + file.getParentFile());
        System.out.println("12 " + File.separator);

        System.out.println();

        File file1 = new File("D:/");

        String[] list = file1.list();
        for (String l : list) {
            System.out.println("String[] " + list);
        }

        System.out.println();

        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println("File[] " + f);
        }

        System.out.println();

        File[] files1 = File.listRoots();
        for (File f1 : files1) {
            System.out.println("Root " + f1);
        }

        File file2 = new File("D:/d");
        // 创建单击目录
        System.out.println(file2.mkdir());
        // 创建多级目录
        System.out.println(file2.mkdirs());
    }
}
