package com.java.se.inteface;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.inteface
 */
public class Test {

    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1==i2);
        System.out.println(i4==i3);

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        str3 = str3.intern();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        String str4 = "you are a joker";
        String substring = str4.substring(4);
        System.out.println(substring);

        String str5 = "fucking";
        String str6 = "fucked";
        System.out.println(str5.concat(str6));


        String a = "abc";
        String b = "def";
        String c = a + b;
        String d = "abc" + "def";

        String e = (a + b).intern();
        System.out.println(c == d);
        System.out.println(d == e);
    }
}
