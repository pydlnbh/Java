package com.develop.manual.question08;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ForStringDemo {

    public static void main(String[] args) {
        // concat拼接方法
        String s = "abcd";
        s = s.concat("e");
        System.out.println(s);

        // 几种拼接方式效率对比
        StringTest(50000);
    }

    private static void StringTest(int testTimes) {
        String str = "str";
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("+ cost: " + (double) (end - start) / 1000 + "s");

        StringBuilder sb = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            sb.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder cost: " + (double) (end - start) / 1000 + "s");

        StringBuffer sb1 = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            sb1.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer cost: " + (double) (end - start) / 1000 + "s");

        String str1 = "str";
        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            str1.concat(",");
        }
        end = System.currentTimeMillis();
        System.out.println("concat cost: " + (double) (end - start) / 1000 + "s");

        String[] list = {"str", "str1"};
        List<String> strings = Arrays.asList(list);
        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            StringUtils.join(strings, ",");
        }
        end = System.currentTimeMillis();
        System.out.println("StringUtils cost: " + (double) (end - start) / 100 + "s");
    }
}
