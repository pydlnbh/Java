package com.develop.manual.question05;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MapCapacityDemo {

    private static void printHashMap(HashMap<String, String> map) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Class<?> mapClass = map.getClass();
        Method capacity = mapClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map));
        Field threshold = mapClass.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold: " + threshold.get(map));
    }

    public static void main(String[] args) throws Exception {
        // initialCapacity / 0.75F + 1.0F
        HashMap<String, String> map = new HashMap<>(7);
        printHashMap(map);

        HashMap<String, String> map1 = Maps.newHashMapWithExpectedSize(7);
        printHashMap(map1);

        HashMap<String, String> map2 = new HashMap<>(16);
        printHashMap(map2);

        HashMap<String, String> map3 = Maps.newHashMapWithExpectedSize(16);
        printHashMap(map3);
    }
}
