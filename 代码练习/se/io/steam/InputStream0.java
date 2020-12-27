package com.java.se.io.steam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.steam
 */
public class InputStream0 {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int read = inputStream.read();
            System.out.println((char)read);
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
