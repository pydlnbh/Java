package com.java.se.inteface;

import com.java.se.inteface.impl.PrinterImpl;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.array
 */
public class TestInnerClass {

    public static void main(String[] args) {
        // 内部类的实例化: new 外部类().new 内部类();
        InnerClassDemo.InnerClass inner = new InnerClassDemo().new InnerClass();
        inner.test();

        InnerClassDemo innerClassDemo = new InnerClassDemo();
        innerClassDemo.show();

        InnerClassDemo.InnerClass2 innerClass2 = new InnerClassDemo.InnerClass2();
        innerClass2.test();

        new PrinterImpl(new Paper() {
            @Override
            public void printA() {

            }

            @Override
            public void printB() {

            }
        });
    }
}
