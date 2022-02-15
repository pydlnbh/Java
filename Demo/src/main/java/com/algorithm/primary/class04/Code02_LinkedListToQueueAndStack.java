package com.algorithm.primary.class04;

/**
 * 单链表实现队列和栈
 */
public class Code02_LinkedListToQueueAndStack {

    public static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class MyQueue<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        public void offer(T value) {
            Node<T> cur = new Node<>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public T pop() {
            T ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        public T peek() {
            T ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    public static class MyStack<T> {
        private Node<T> head;
        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        public void push(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public T pop() {
            T ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

        public T peek() {
            return head != null ? head.value : null;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.offer(2);
        mq.offer(3);
        System.out.println(mq.peek());
        System.out.println(mq.getSize());
        System.out.println(mq.pop());
        System.out.println(mq.peek());

        MyStack<Integer> ms = new MyStack<>();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.getSize());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.isEmpty());
    }
}
