package com.design.pattern.db.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(""); // test
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();

        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
