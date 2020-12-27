package com.java.se.io.steam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.steam
 */
public class CopyPicture {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("algorithm01\\01.jpg");
            outputStream = new FileOutputStream("algorithm01\\02.jpg");
            byte[] buffer = new byte[1024];
            while ((inputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
