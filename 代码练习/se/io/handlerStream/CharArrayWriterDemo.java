package com.java.se.io.handlerStream;

import java.io.CharArrayWriter;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.handlerStream
 */
public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter charArrayWriter = null;
        charArrayWriter = new CharArrayWriter();
        charArrayWriter.write(68);
        charArrayWriter.write(96);
        charArrayWriter.write(33);
        System.out.println(charArrayWriter);
        charArrayWriter.close();
    }
}
