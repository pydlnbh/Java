package com.se.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.file
 */
public class FileDemo1 {
    // 主入口
    public static void main(String[] args) {
        printFiles(new File("D:\\Downloads"));
    }

    // 遍历输出某个文件夹下所有文件的绝对路径
    public static void printFiles(File file) {
        // 判断File是否为空
        if (file.isDirectory()) {
            // 取出每一个File
            File[] files = file.listFiles();
            for (File f : files) {
                printFiles(f);
            }
        } else {
            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
