package com.se.inteface.impl;

import com.se.inteface.InkBox;
import com.se.inteface.Paper;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.inteface.impl
 */
public class PrinterImpl implements InkBox, Paper {

    public PrinterImpl() {

    }

    public PrinterImpl(Paper paper) {
        System.out.print("测试匿名内部类");
    }

    public static void main(String[] args) {
        PrinterImpl printer = new PrinterImpl();
        printer.blankAndWhite();
        printer.printA();
    }

    @Override
    public void blankAndWhite() {
        System.out.print("使用黑白墨盒打印");
    }

    @Override
    public void color() {
        System.out.println("使用彩色墨盒打印");
    }

    @Override
    public void printA() {
        System.out.print("A4纸");
    }

    @Override
    public void printB() {
        System.out.print("B5纸");
    }
}
