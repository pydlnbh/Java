package com.java.se.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class TestIterator {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        // 迭代器
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//        }

        // ListIterator 可以向前和先后遍历
        ListIterator iterator1 = list.listIterator();

        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        System.out.println();

        while (iterator1.hasPrevious()) {
            System.out.print(iterator1.previous() + " ");
        }

        System.out.println();

        // 使用for循环遍历迭代器对象, for循环结束, 迭代器对象就被回收了, 推荐使用
        for (ListIterator iterator = list.listIterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }

//        System.out.println();
//
//        // 增强for循环
//        for (String str : list) {
//            System.out.print(str + " ");
//        }
    }
}
