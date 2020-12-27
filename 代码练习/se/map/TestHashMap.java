package com.java.se.map;

import java.util.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/27
 * @Description: com.java.se.map
 *
 * API:
 *      增加:
 *          put(k, v)   添加元素
 *      查找:
 *          isEmpty     判断是否为空
 *          size        返回map大小
 *          containKey  是否有key
 *          containValue是否有value
 *      删除:
 *          clear       清空集合中的所有元素
 *          remove      删除指定元素
 *      Map.entry: 表示k-v组合的一组映射关系, key和value成组出现
 */
public class TestHashMap {
    // 主入口
    public static void main(String[] args) {
        // 实例化一个HashMap对象
        HashMap<Integer, String> map = new HashMap<>();

        // 添加元素
        map.put(0, "zs");
        map.put(1, "ls");
        map.put(2, "ws");

        // 查找元素
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.containsKey(0));
        System.out.println(map.containsValue("ls"));

        // 删除
        // map.clear();
        System.out.println(map.remove(0));

        // 遍历
        Set<Integer> key = map.keySet();
        for (Integer i : key) {
            System.out.println(map.get(i));
        }

        // 只能获取对应的value值, 不能根据value获取key
        Collection<String> values = map.values();
        for (String i : values) {
            System.out.println(i);
        }

        // 使用Iterator遍历
        Set<Integer> key1 = map.keySet();
        for (Iterator<Integer> iterator = key1.iterator(); iterator.hasNext(); ) {
            Integer key2 = iterator.next();
            System.out.println(key2 + "--->" + map.get(key2));
        }

        // Map.Entry
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iterator = entries.iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "====>" + next.getValue());
        }
    }
}
