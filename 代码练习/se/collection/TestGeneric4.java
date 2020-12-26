package com.java.se.collection;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class TestGeneric4 {
    public static void main(String[] args) {
        GenericMethod<String> me = new GenericMethod<String>("String");
        me.test("123");
        me.test(true);
    }
}
