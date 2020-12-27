package com.java.se.io.character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.character
 */
public class ReaderDemo2 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("abc.txt");
            int length = 0;

            char[] chars = new char[1024];
            while ((length = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, length));
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
