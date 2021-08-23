package com.se.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 实现多线程第一种方式
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run...");
            }
        });
        // 就绪状态
        thread.start();

        // 使用lambda表达式实现多线程
        new Thread(() -> {
            System.out.println("running1...");
        }).start();

        // 使用Arrays工具类的asList()方法声明一个List集合
        List<String> list = Arrays.asList("java", "javaScript", "scala", "python");

        // 使用Collections工具类的sort排序方法, 重写比较器接口
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//
//        // 循环遍历
//        for (String str : list) {
//            System.out.println(str);
//        }

        // 使用Lambda表达式sort排序
        Collections.sort(list, (a, b) -> a.length() - b.length());
        list.forEach(System.out::println);
    }
}
