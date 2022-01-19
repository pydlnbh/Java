package com.develop.manual.question08;

import org.springframework.util.StringUtils;

public class ForDemo {

    public static void main(String[] args) {
        String s = "abcd";
        String e = s.concat("e");
        System.out.println(s + " " + e);

        // TODO 集中拼接字符串耗时对比
    }
}
