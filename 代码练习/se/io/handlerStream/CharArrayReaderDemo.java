package com.java.se.io.handlerStream;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.handlerStream
 */
public class CharArrayReaderDemo {
    public static void main(String[] args) {
        char[] chars = "demo测试".toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        try {
            int read = 0;
            while ((read = charArrayReader.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayReader.close();
        }
    }
}
