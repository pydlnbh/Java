package com.java.se.inteface;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/24 - 12 - 24 - 16:59
 * @Description: com.java.se.array
 * @Version: 1.0
 */
public class InnerClassDemo {

    private int i = 3;

    public void show() {
        InnerClass innerClass = new InnerClass();
        System.out.println(innerClass.j);
        innerClass.test2();
    }

    private void show2() {
        System.out.println("1111");
    }

    class InnerClass {

        private  int j = 2;

        public void test() {
            System.out.println("test " + i);
            show2();
        }

        private void test2() {
            System.out.println("test2");
        }
    }

    static class InnerClass2 {
        public void test() {
            System.out.println("test3");
        }
    }
}
