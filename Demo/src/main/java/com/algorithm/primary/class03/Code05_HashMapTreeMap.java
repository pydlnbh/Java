package com.algorithm.primary.class03;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * HashMap的时间复杂度是O(1)
 * TreeMap的时间复杂度是O(logN)
 */
public class Code05_HashMapTreeMap {

    public static class Node {
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // HashMap 中的元素实际上是对象，一些常见的基本类型可以使它的包装类来代替 包装类型是按值传递
        HashMap<String, String> map = new HashMap<>();
        map.put("pyd", "peiyiding");
        System.out.println(map.containsKey("pyd"));
        System.out.println(map.containsKey("p"));
        System.out.println(map.get("pyd"));

        map.put("pyd", "pyddddd");
        System.out.println(map.get("pyd"));

//        map.remove("pyd");
//        System.out.println(map.containsKey("pyd"));
//        System.out.println(map.get("pyd"));

        String test1 = "pyd";
        String test2 = "pyd";
        System.out.println(map.containsKey(test1));
        System.out.println(map.containsKey(test2));

        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1234567, "i am 1234567");

        Integer a = 1234567;
        Integer b = 1234567;

//        System.out.println(a == b); 对象类型应该是用equals
        System.out.println(map1.containsKey(a));
        System.out.println(map1.containsKey(b));

        // 自定义类型是按引用传递
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> map2 = new HashMap<>();
        map2.put(node1, "i am in");
        System.out.println(map2.containsKey(node1));
        System.out.println(map2.containsKey(node2));

        System.out.println("========================");

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "i am 3");
        treeMap.put(0, "i am 0");
        treeMap.put(7, "i am 7");
        treeMap.put(2, "i am 2");
        treeMap.put(1, "i am 1");

        System.out.println(treeMap.containsKey(7));
        System.out.println(treeMap.containsKey(3));
        System.out.println(treeMap.get(2));

        treeMap.put(3, "different 3");
        System.out.println(treeMap.get(3));

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

        // <= 3最近的数字
        System.out.println(treeMap.floorKey(3));
        // <= 4最近的数字
        System.out.println(treeMap.floorKey(4));

        // >= 7最近的数字
        System.out.println(treeMap.ceilingKey(7));
        // >= 4最近的数字
        System.out.println(treeMap.ceilingKey(4));


        Node node3 = new Node(3);
        Node node4 = new Node(4);
        // TreeMap key 不能放自定义类型
        TreeMap<Node, String> treeMap1 = new TreeMap<>();
//        treeMap1.put(node3, "i am node3");
//        treeMap1.put(node4, "i am node4");
    }

}
