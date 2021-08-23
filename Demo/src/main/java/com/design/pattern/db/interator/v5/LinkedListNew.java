package com.design.pattern.db.interator.v5;

public class LinkedListNew<E> implements CollectionNew<E>{
    Node head = null;
    Node tail = null;
    private int size = 0;

    @Override
    public void add(E o) {
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

    @Override
    public IteratorNew<E> iterator() {
        return new LinkedListIterator<>();
    }

    private class LinkedListIterator<E> implements IteratorNew<E> {
        Node cur;

        LinkedListIterator() {
            cur = head;
        }
        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            E val = (E) cur.val;
            cur = cur.next;
            return val;
        }
    }

    private class Node<E> {
        private E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

}
