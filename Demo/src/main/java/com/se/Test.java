package com.se;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ForkJoinPool;

public class Test {
    public static void main(String[] args) {
        Integer i = 0000;
        Integer j = 726;

        String a = "0000";
        String b = "123";
        String c = "8888121";
        a = a.substring(b.length());
        a += b;

        String format = String.format("%04d", j);
        System.out.println("---"+ format);

        System.out.println(j);
        System.out.println(a);
        System.out.println(b);

        System.out.println(c.substring(c.length() - 4));

        String str = "7981234131234";
        System.out.println(str);
        Integer sss = Integer.valueOf(str.substring(str.length() - 4));
        sss += 1;
        str = str.substring(0, str.length() - 4) + sss;
        System.out.println(str);

        Integer x = 1;
        System.out.println(x == 1);
    }
}
