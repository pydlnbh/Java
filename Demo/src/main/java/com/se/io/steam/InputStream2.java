package com.se.io.steam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.steam
 */
public class InputStream2 {
    public static void main(String[] args) {
        // 这里必须初始化, 否则关闭不了
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int length = 0;

            // 添加缓冲区的方法, 必须是byte[]数组
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
