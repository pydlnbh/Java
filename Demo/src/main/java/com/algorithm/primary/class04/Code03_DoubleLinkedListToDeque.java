package com.algorithm.primary.class04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双向链表转为双端队列
 */
public class Code03_DoubleLinkedListToDeque {

    public static class DoubleNode<T> {
        public DoubleNode<T> last;
        public DoubleNode<T> next;
        public T value;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    public static class MyDeque<T> {
        private DoubleNode<T> head;
        private DoubleNode<T> tail;
        private int size;

        public MyDeque() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void pushHead(T value) {
            DoubleNode<T> cur = new DoubleNode<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        public void pushTail(T value) {
            DoubleNode<T> cur = new DoubleNode<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
            size++;
        }

        public T pollHead() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public T pollTail() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public T peekHead() {
            return head != null ? head.value : null;
        }

        public T peekTail() {
            return tail != null ? tail.value : null;
        }
    }

    public static void main(String[] args) {
        MyDeque<Integer> myDeque = new MyDeque<>();
        Deque<Integer> test = new LinkedList<>();
        int testTimes = 400000;
        int maxValue = 120000;

        System.out.println("测试开始！");

        for (int i = 0; i < testTimes; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops! 404");
                break;
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops! 404");
                break;
            }
            // 利用随机来选择push还是pop
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (maxValue * Math.random());
                if (Math.random() < 0.5) {
                    myDeque.pushHead(num);
                    test.addFirst(num);
                } else {
                    myDeque.pushTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.pollHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.pollTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops! 404");
                        break;
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops! 404");
                        break;
                    }
                }
            }
        }

        if (myDeque.size() != test.size()) {
            System.out.println("Oops! 404");
        }

        while (!myDeque.isEmpty()) {
            int num1 = myDeque.pollHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops! 404");
            }
        }
        System.out.println("测试结束！");
    }
}
