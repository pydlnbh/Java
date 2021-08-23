package com.se.io.steam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.io.steam
 */
public class InputStream1 {
    public static void main(String[] args) {
        FileInputStream inputSteam = null;
        try {
            inputSteam = new FileInputStream("abc.txt");
            int read = 0;
            while ((read = inputSteam.read()) != -1) {
                System.out.println((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputSteam.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
