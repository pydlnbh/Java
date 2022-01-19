package com.develop.manual.question04;

import cn.hutool.core.date.DateUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HashMapDemo {

    public static void mapTest() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");

        Class<?> aClass = map.getClass();
        Method capacity = aClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map));

        Method size = aClass.getDeclaredMethod("size");
        size.setAccessible(true);
        System.out.println("size: " + size.invoke(map));
    }

    public static void mapCapacityTest() throws Exception{
        mapSizeTest(1);
        mapSizeTest(7);
        mapSizeTest(9);
        mapSizeTest(16);
    }

    private static void mapSizeTest(int size) throws Exception {
        HashMap<String, String> map = new HashMap<>(size);
        Class<?> mapClass = map.getClass();
        Method capacity = mapClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map));

        Field threshold = mapClass.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold: " + threshold.get(map));
    }

    public static void resizeTest() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("test01", "test");
        map.put("test02", "test");
        map.put("test03", "test");
        map.put("test04", "test");
        map.put("test05", "test");
        map.put("test06", "test");
        map.put("test07", "test");
        map.put("test08", "test");
        map.put("test09", "test");
        map.put("test10", "test");
        map.put("test11", "test");
        map.put("test12", "test");
        Class<? extends HashMap> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size: " + size.get(map));

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold: " + threshold.get(map));

        Field loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        System.out.println("loadFactor: " + loadFactor.get(map));

        map.put("test13", "test");
        capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map));

        size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size: " + size.get(map));

        threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold: " + threshold.get(map));

        loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        System.out.println("loadFactor: " + loadFactor.get(map));
    }

    public static void newHashMap(int aHundredMillion) throws Exception{
        // 从默认容量16开始扩容
        HashMap<Integer, Integer> map = new HashMap<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("未初始化容量, 耗时: " + (double) (end - start) / 1000 + "s");

        // 从容量500w开始扩容一次到1kw
        HashMap<Integer, Integer> map1 = new HashMap<>(aHundredMillion >> 1);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("初始化容量500w, 然后扩容一次到1kw, 耗时: " + (double) (end1 - start1) / 1000 + "s");

        Class<? extends HashMap> aClass = map1.getClass();
        Method capacity = aClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map1));
        Field threshold = aClass.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold: " + threshold.get(map1));

        // 初始化容量1kw开始
        HashMap<Integer, Integer> map2 = new HashMap<>(aHundredMillion);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("初始化容量1kw, 耗时: " + (double) (end2 - start2) / 1000 + "s");

        Class<? extends HashMap> map2Class = map2.getClass();
        Method capacity1 = map2Class.getDeclaredMethod("capacity");
        capacity1.setAccessible(true);
        System.out.println("capacity: " + capacity1.invoke(map2));
        Field threshold1 = map2Class.getDeclaredField("threshold");
        threshold1.setAccessible(true);
        System.out.println("threshold: " + threshold1.get(map2));
    }

    public static void main(String[] args) throws Exception {
        // 利用反射方式打印capacity(16)和size(1)
        mapTest();
        System.out.println("==========================");
        // 一个数字作为容量，那么 Hash 会选择大于该数字的第一个 2 的幂作为容量。(1->1、7->8、9->16)
        mapCapacityTest();
        System.out.println("==========================");
        // 自动扩容测试，threshold * loadFactor
        resizeTest();
        System.out.println("==========================");
        // 初始化容量大小的效率对比
        newHashMap(10000000);
    }
}
