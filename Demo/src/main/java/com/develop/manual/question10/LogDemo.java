package com.develop.manual.question10;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {

    public static void main(String[] args) {
        Logger.getLogger("any").log(Level.WARNING, "test");
    }
}
