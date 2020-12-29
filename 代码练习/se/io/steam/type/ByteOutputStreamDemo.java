package com.java.se.io.steam.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.steam
 */
public class ByteOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(98);
        try {
            byteArrayOutputStream.write("fjksdljfl".getBytes());
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
