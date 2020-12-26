package com.java.se.collection;

import java.util.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class TestSet implements Comparator<Person> {
    public static void main(String[] args) {
        // 实例化HashSet集合
        Set set = new HashSet();

        // 添加元素
        set.add(1);
        set.add(true);
        set.add("abc");

        // 迭代器对象
        Iterator iterator = set.iterator();

        // 使用while循环遍历
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("===============");

        // 使用for循环遍历
        for (Iterator iterator1 = set.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator1.next() + " ");
        }

        // 实例化TreeSet对象
        TreeSet treeSet = new TreeSet(new TestSet());
        treeSet.add(new Person("zs", 30));
        treeSet.add(new Person("zss", 2));
        treeSet.add(new Person("lisi", 22));
        System.out.println(treeSet);
    }

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
