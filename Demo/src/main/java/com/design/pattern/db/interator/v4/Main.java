package com.design.pattern.db.interator.v4;

public class Main {
    public static void main(String[] args) {
        CollectionNew list = new ArrayListNew();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());

        IteratorNew it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("--------------------------------");

        CollectionNew LinkedList = new LikedListNew();
        for (int i = 0; i < 15; i++) {
            LinkedList.add("s" + i);
        }
        System.out.println(LinkedList.size());

        IteratorNew iterator = LinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
