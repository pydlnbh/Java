package com.java.se.collection;

import java.util.ArrayList;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        // list.add(1); 相当于list.add(new Integer(1));
        // list.add(true); 相当于list.add(new Boolean(true));
        list.add("String"); // 相当于list.add(new String("String"));
        list.add(new Person("zss", 12).toString());

        // 使用for循环遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // 使用get()方法打印输出
        }

        System.out.println();

        for (String l : list) {
            System.out.print(l + " ");
        }
    }
}
