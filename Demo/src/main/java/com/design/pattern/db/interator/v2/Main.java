package com.design.pattern.db.interator.v2;

public class Main {
    public static void main(String[] args) {
        LinkedListNew linkedListNew = new LinkedListNew();
        for (int i = 0; i < 15; i++) {
            linkedListNew.add("s" + i);
        }
        System.out.println(linkedListNew.size());
    }
}
