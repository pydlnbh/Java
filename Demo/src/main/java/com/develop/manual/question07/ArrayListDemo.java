package com.develop.manual.question07;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>() {{
            add("test1");
            add("test2");
            add("test3");
        }};

        List<String> subList = names.subList(0, 1);
        System.out.println(subList);

//        ArrayList subList1 = (ArrayList) names.subList(1, 2); // ClassCastException 类转换异常

        // 更改子列表，同时更改了父列表
        subList.set(0, "666");
        System.out.println(names);
        System.out.println(subList);

        // 在子列表添加元素，父列表也追加了元素
        subList.add("999");
        System.out.println(names);
        System.out.println(subList);

        // 在父列表添加元素 ConcurrentModificationException CMException
//        names.add("100");
//        System.out.println(names);
//        System.out.println(subList);

        // 创建subList的拷贝
        ArrayList<String> list = Lists.newArrayList(subList);
        List<String> collect = list.stream().skip(0).limit(1).collect(Collectors.toList());
        System.out.println(collect);
    }
}
