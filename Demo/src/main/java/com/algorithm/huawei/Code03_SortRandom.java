package com.algorithm.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*
* 随机数排序
* */
public class Code03_SortRandom {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int num = sc.nextInt();
//            TreeSet set = new TreeSet();
//            for (int i = 0; i < num; i++) {
//                set.add(sc.nextInt());
//            }
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
//        }
        pra01();
    }

    static void pra01() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            TreeSet set = new TreeSet();

            for (int i = 0; i < num; i++) {
                set.add(sc.nextInt());
            }

            Iterator it = set.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
}
