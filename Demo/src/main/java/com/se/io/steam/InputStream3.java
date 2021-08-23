package com.se.io.steam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.steam
 */
public class InputStream3 {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int length = 0;

            // 添加缓冲区的方式读取, 每次都会将数据添加到缓冲区, 当缓冲区满了之后会一次读取, 而不是每一个字节读取
            byte[] buffer = new byte[1024];
            // 这个长度得赋值, 不然读不了
            while ((length = inputStream.read(buffer, 5, 5)) != -1) {
                System.out.println(new String(buffer, 5, length));
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
