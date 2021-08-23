package com.se.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.collections
 */
public class CollectionDemo {
    public static void main(String[] args) {
        // 实例化一个集合
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("asdf");
        list.add("as");
        list.add("asaa");
        list.add("ret");

        // 使用Collections工具类添加元素
        Collections.addAll(list,"1asdf", "dsf");
        System.out.println(list);

        // 排序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);

        // 使用Collections工具类排序
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);

        // 使用Collections工具类进行二分查找
        int i = Collections.binarySearch(list, "as");
        System.out.println(i);

        // 使用Collections工具类逆序
        Collections.reverse(list);
        System.out.println(list);

        // 使用Collections工具类进行随机排序
        Collections.shuffle(list);
        System.out.println(list);

        // 使用Collections工具类进行替换
        Collections.fill(list, "gfj");
        System.out.println(list);
    }
}
