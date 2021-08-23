package com.se.io.character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.character
 */
public class ReaderDemo3 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("abc.txt");
            int length = 0;
            // 添加缓冲区的方式读取
            char[] chars = new char[1024];
            while ((length = reader.read(chars, 5, 5)) != -1) {
                System.out.println(new String(chars, 5, 5));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
