package com.design.pattern.db.interator.v3;

public class Main {
    public static void main(String[] args) {
        CollectionNew list = new ArrayListNew();
        CollectionNew linkedList = new LinkedListNew();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
            linkedList.add("l" + i);
        }
        System.out.println(list.size());
        System.out.println(linkedList.size());
    }
}
