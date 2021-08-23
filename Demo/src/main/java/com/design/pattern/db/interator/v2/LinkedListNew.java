package com.design.pattern.db.interator.v2;

public class LinkedListNew {
    Node head = null;
    Node tail = null;

    private int size = 0;

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

    public int size() {
        return size;
    }
}
