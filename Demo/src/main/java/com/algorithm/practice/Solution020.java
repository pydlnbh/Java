package com.algorithm.practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution020 {

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class Linked<T> {
        private T val;
        private Linked<T> next;

        public Linked(T value) {
            val = value;
        }
    }

    private static class DoubleNode {
        private int value;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    private static class DoubleLinked<T> {
        private T val;
        private DoubleLinked<T> pre;
        private DoubleLinked<T> next;

        public DoubleLinked(T val) {
            this.val = val;
        }
    }

    /**
     * 反转单链表
     *
     * @param head 头结点
     * @return Node
     */
    public static Node reverseLinkedList(Node head) {
        Node next;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双链表
     *
     * @param head 头结点
     * @return DoubleNode
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode next;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 用单链表实现队列
     *
     * @param <T> 泛型
     */
    public static class MyQueue<T> {
        private int size;
        private Linked<T> head;
        private Linked<T> last;

        public MyQueue() {
            size = 0;
            head = null;
            last = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(T value) {
            Linked<T> cur = new Linked<>(value);
            if (head == null) {
                head = cur;
                last = cur;
            } else {
                last.next = cur;
                last = cur;
            }
            size++;
        }

        public T pop() {
            T ans = null;
            if (head == null) {
                last = null;
                return ans;
            } else {
                ans = head.val;
                head = head.next;
            }
            size--;
            return ans;
        }

        public T peek() {
            return head != null ? head.val : null;
        }
    }

    /**
     * 用单链表实现栈
     *
     * @param <T> 泛型
     */
    public static class MyStack<T> {
        private Linked<T> head;
        private int size;

        public MyStack() {
            size = 0;
            head = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(T val) {
            Linked<T> cur = new Linked<>(val);
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
            if (head == null) {
                return ans;
            } else {
                ans = head.val;
                head = head.next;
            }
            size--;
            return ans;
        }

        public T peek() {
            return head != null ? head.val : null;
        }
    }

    /**
     * 用双链表实现双端队列
     *
     * @param <T>泛型
     */
    public static class MyDeque<T> {
        private int size;
        private DoubleLinked<T> head;
        private DoubleLinked<T> tail;

        public MyDeque() {
            size = 0;
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void pushHead(T val) {
            DoubleLinked<T> cur = new DoubleLinked<>(val);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
            size++;
        }

        public void pushTail(T val) {
            DoubleLinked<T> cur = new DoubleLinked<>(val);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
            size++;
        }

        public T popHead() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.val;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return ans;
        }

        public T popTail() {
            T ans = null;
            if (tail == null) {
                return ans;
            }
            size--;
            ans = tail.val;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
            return ans;
        }

        public T peekHead() {
            return head != null ? head.val : null;
        }

        public T peekTail() {
            return tail != null ? tail.val : null;
        }
    }

    /**
     * K个节点的组内逆序调整问题： 给定一个单链表的头节点head，和一个正数k 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
     * 例子: 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
     *
     * @param head 头结点
     * @param k k个节点
     * @return Node
     */
    public static Node reverseKGroup(Node head, int k) {
        Node start = head;
        Node end = getkEnd(head, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverseKGroup(start, end);
        Node lastEnd = end;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getkEnd(start, k);
            if (end == null) {
                return head;
            }
            reverseKGroup(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static Node getkEnd(Node start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverseKGroup(Node start, Node end) {
        end = end.next;
        Node cur = start;
        Node pre = null;
        Node next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
     * 两个链表相加问题 给定两个链表的头节点head1和head2， 认为从左到右是某个数字从低位到高位，返回相加之后的链表
     * 例子 4 -> 3 -> 6 2 -> 5 -> 3 返回 6 -> 8 -> 9 解释 634 + 352 = 986
     */
    public static Node addTwoLinkedList(Node head1, Node head2) {
        int l1 = getNodeLength(head1);
        int l2 = getNodeLength(head2);
        Node longer = l1 >= l2 ? head1 : head2;
        Node shorter = longer == head1 ? head2 : head1;
        Node curS = shorter;
        Node curL = longer;
        Node last = curL;
        int carry = 0;
        int curSum;
        while (curS != null) {
            curSum = curS.value + curL.value + carry;
            curL.value = (curSum % 10);
            carry = curSum / 10;
            last = curL;
            curS = curS.next;
            curL = curL.next;
        }
        while (curL != null) {
            curSum = curL.value + carry;
            curL.value = (carry % 10);
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new Node(1);
        }
        return longer;
    }

    public static int getNodeLength(Node head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    /**
     * 两个有序链表的合并 给定两个有序链表的头节点head1和head2， 返回合并之后的大链表，要求依然有序
     * 例子 1 -> 3 -> 3 -> 5 -> 7 2 -> 2 -> 3 -> 3-> 7 返回 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
     *
     * @param head1 头节点
     * @param head2 头节点
     * @return Node
     */
    public static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value <= head2.value ? head1 : head2;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    /**
     * 测试反转单链表
     */
    public static void testReverseLinkedList() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        head.next = node1;
        node1.next = node2;
        Node node = reverseLinkedList(head);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 测试反转双链表
     */
    public static void testReverseDoubleLinkedList() {
        DoubleNode head = new DoubleNode(0);
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        head.next = doubleNode1;
        doubleNode1.pre = head;
        doubleNode1.next = doubleNode2;
        doubleNode2.pre = doubleNode1;
        DoubleNode next = reverseDoubleLinkedList(head);
        DoubleNode pre = next;
        while (next != null) {
            System.out.println(next.value);
            next = next.next;
        }
        System.out.println("=========");
        while (pre != null) {
            System.out.println(pre.value);
            pre = pre.pre;
        }
    }

    /**
     * 测试用单链表实现队列
     */
    public static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }

    /**
     * 测试用单链表实现栈
     */
    public static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());
    }

    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.pop();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.pop();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    /**
     * 测试用双链表实现双端队列
     */
    public static void testMyDeque() {
        MyDeque<Integer> deque = new MyDeque<>();
        deque.pushHead(1);
        deque.pushHead(0);
        deque.pushTail(2);
        deque.pushTail(3);
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        System.out.println(deque.peekHead());
        System.out.println(deque.peekTail());
        System.out.println(deque.popHead());
        System.out.println(deque.popTail());
        System.out.println(deque.size());
        System.out.println(deque.peekHead());
        System.out.println(deque.peekTail());
    }

    /**
     * 测试用双链表实现双端队列
     */
    public static void testMyDeque1() {
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
                        num1 = myDeque.popHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.popTail();
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
            int num1 = myDeque.popHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops! 404");
            }
        }
        System.out.println("测试结束！");
    }

    /**
     * main
     *
     * @param args 标准形参
     */
    public static void main(String[] args) {
//        testReverseLinkedList();
//        testReverseDoubleLinkedList();
//        testMyQueue();
//        testMyStack();
//        testMyDeque();
//        testMyDeque1();
//        testQueue();
//        testStack();
    }
}
