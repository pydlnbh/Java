package com.design.pattern.db.interator.v1;

public class Main {
    public static void main(String[] args) {
        ArrayListNew list = new ArrayListNew();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}
