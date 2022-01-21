package com.develop.manual.question09;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ForEachDemo {

    public static void main(String[] args) {
        // 使用iterator遍历, remove元素
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (Objects.equals("1", item)) {
                iterator.remove();
            }
        }
        System.out.println(list);

        // 使用增强for循环remove元素
        ArrayList<String> a = new ArrayList<String>() {{
            add("1");
            add("2");
        }};
        for (String item : a) {
            if (Objects.equals("2", item)) {
                a.remove(item); // 如果没有break, 就会发生CME
                break;
            }
        }
        System.out.println(a);

        ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3", "4", "5");
        System.out.println("使用for循环遍历List");
        for (int i = 0; i < immutableList.size(); i++) {
            System.out.println(immutableList.get(i));
        }

        System.out.println("使用foreach遍历List");
        for (String item : immutableList) {
            System.out.println(item);
        }

        // deque 双端队列
        ConcurrentLinkedDeque<String> linkedDeque = new ConcurrentLinkedDeque<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        for (String item : linkedDeque) {
            if (Objects.equals("3", item)) {
                linkedDeque.remove();
            }
        }
        System.out.println(linkedDeque);
    }
}
