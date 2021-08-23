package com.design.pattern.db.decorator;

import java.io.*;

public abstract class Main {
    public static void main(String[] args) throws Exception {
        File f = new File("");
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("Decorator design pattern");
        bw.flush();
        bw.close();
    }
}
