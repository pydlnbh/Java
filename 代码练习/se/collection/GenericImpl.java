package com.java.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class GenericImpl implements GenericInterface<String> {
    @Override
    public String test() {
        return "String";
    }

    @Override
    public void test1() {
        System.out.print("print test1");
    }
}
