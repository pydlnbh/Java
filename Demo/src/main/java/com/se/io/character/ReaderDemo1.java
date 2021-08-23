package com.se.io.character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.character
 */
public class ReaderDemo1 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("abc.txt");
            int read = 0;
            while ((read = reader.read()) != -1) {
                System.out.println((char) read);
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
