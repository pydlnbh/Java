package com.java.se.exception;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.exception
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        System.out.println("自定义异常");
    }
}
