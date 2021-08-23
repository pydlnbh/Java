package com.design.pattern.db.flyweight;

public class TestString {
    public static void main(String[] args) {
        String s = "abc";
        String st = "abc";
        String str = new String("abc");
        String string = new String("abc");

        // compare
        System.out.println(s == st);
        System.out.println(s == str);
        System.out.println(str == string);
        System.out.println(str.intern() == s);
        System.out.println(str.intern() == string.intern());
    }
}
