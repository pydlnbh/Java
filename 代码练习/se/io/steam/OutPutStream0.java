package com.java.se.io.steam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.steam
 */
public class OutPutStream0 {
    public static void main(String[] args) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("aaa.txt");
            outputStream.write(97);
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
        }
    }
}
