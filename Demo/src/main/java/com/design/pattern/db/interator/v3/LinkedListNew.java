package com.design.pattern.db.interator.v3;

public class LinkedListNew implements CollectionNew {
    Node head = null;
    Node tail = null;
    private int size = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null) {
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }
}
