package com.java.se.collection;

import java.util.*;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.collection
 */
public class TestGeneric5 implements Comparator<SE> {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<PM> pms = new ArrayList<PM>();
        pms.add(new PM(123));
        System.out.println(pms);

        // LinkedList
        LinkedList<SE> ses = new LinkedList<SE>();
        ses.add(new SE(123));
        System.out.println(ses);

        // HashSet
        HashSet<PM> pms1 = new HashSet<PM>();
        pms1.add(new PM(123, "adf", 12, Gender.MALE ,12));
        System.out.println(pms1);

        // TreeSet
        TreeSet<SE> ses1 = new TreeSet<SE>(new TestGeneric5());
        ses1.add(new SE(44, "zs", 22, Gender.FEMALE, 100));
        System.out.println(ses1);
    }

    @Override
    public int compare(SE o1, SE o2) {
        if (o1.getId() > o2.getId()) {
            return 1;
        } else if (o1.getId() < o2.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
