package com.algorithm.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 */
public class Code08_MergeTable {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        int nums = sc.nextInt();
//
//        for (int i = 0; i < nums; i++) {
//            int key = sc.nextInt();
//            int value = sc.nextInt();
//
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + value);
//            } else {
//                map.put(key, value);
//            }
//        }
//
//        for (int key : map.keySet()) {
//            System.out.println(key + " " + map.get(key));
//        }

        pra01();
    }

    public static void pra01() {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }

        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
