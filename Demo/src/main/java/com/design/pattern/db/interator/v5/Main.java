package com.design.pattern.db.interator.v5;

public class Main {
    public static void main(String[] args) {
        CollectionNew<Integer> list = new ArrayListNew<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        System.out.println(list.size());

        IteratorNew<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-----------------");

        CollectionNew<String> LinkedList = new LinkedListNew<>();
        for (int i = 0; i < 15; i++) {
            LinkedList.add("L" + i);
        }
        System.out.println(LinkedList.size());

        IteratorNew<String> iterator = LinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
