package com.java.se.io.steam.type;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.steam
 */
public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String str = "sdkfjlsdk";
        byte[] bytes = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(bytes);
        int read = 0;
        while ((read = byteArrayInputStream.read()) != -1) {
            // 从输入流中跳过n个字节的输入
            byteArrayInputStream.skip(2);
            System.out.println((char) read);
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
