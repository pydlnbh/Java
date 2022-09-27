package com.algorithm.study.practice;

import com.algorithm.primary.class04.Code03_DoubleLinkedListToDeque;

import java.util.Deque;
import java.util.LinkedList;

public class Solution002 {

    public static void main(String[] args) {
//        basicTest();
        testMyDeque();
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.pre = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 打印链表
     *
     * @param head 头节点
     */
    private static void printNode(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void basicTest() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);

        // 打印链表
        printNode(node);

        System.out.print("反转链表之后: ");
        // 反转链表
        Node reverseNode = reverseList02(node);

        // 打印链表
        printNode(reverseNode);

        DoubleNode dn0 = new DoubleNode(1);
        DoubleNode dn1 = new DoubleNode(2);
        DoubleNode dn2 = new DoubleNode(3);
        dn0.next = dn1;
        dn1.pre = dn0;
        dn1.next = dn2;
        dn2.pre = dn1;

        printDoubleNode(dn0);

        printDoubleNodeLast(dn0);

        // 反转链表
        DoubleNode doubleNode = reverseDoubleList02(dn0);

        System.out.println("=========反转后=========");

        printDoubleNode(doubleNode);

        printDoubleNodeLast(doubleNode);
    }

    private static void printDoubleNodeLast(DoubleNode head) {
        System.out.println("向前遍历");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.pre;
        }
        System.out.println();
    }

    private static void printDoubleNode(DoubleNode head) {
        System.out.println("向后遍历: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverseList01(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList01(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverseList02(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList02(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class NodeT<T> {
        public T value;
        public NodeT<T> next;

        public NodeT(T value) {
            this.value = value;
        }
    }

    public static class MyQueue<T> {
        private NodeT<T> head;
        private NodeT<T> tail;
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
            NodeT<T> cur = new NodeT<>(value);
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
            return head == null ? null : head.value;
        }

    }

    public static class MyQueue01<T> {
        private NodeT<T> head;
        private NodeT<T> tail;
        private int size;

        public MyQueue01() {
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
            NodeT<T> cur = new NodeT<>(value);
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
            return head == null ? null : head.value;
        }
    }

    public static class MyQueue02<T> {
        private NodeT<T> head;
        private NodeT<T> tail;
        private int size;

        public MyQueue02() {
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
            NodeT<T> cur = new NodeT<>(value);
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
            return head == null ? null : head.value;
        }
    }

    public static class MyStack<T> {
        private NodeT<T> head;
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
            NodeT<T> cur = new NodeT<>(value);
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
            return head == null ? null : head.value;
        }
    }

    public static class MyStack01<T> {
        private NodeT<T> head;
        private int size;

        public MyStack01() {
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
            NodeT<T> cur = new NodeT<>(value);
            if (head != null) {
                cur.next = head;
                head = cur;
            } else {
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

    public static class MyStack02<T> {
        private NodeT<T> head;
        private int size;

        public MyStack02() {
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
            NodeT<T> cur = new NodeT<>(value);
            if (head != null) {
                cur.next = head;
                head = cur;
            } else {
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

    public static class DoubleNode01<T> {
        public DoubleNode01<T> pre;
        public DoubleNode01<T> next;
        public T value;

        public DoubleNode01(T value) {
            this.value = value;
        }
    }

    public static class MyDeque<T> {
        private DoubleNode01<T> head;
        private DoubleNode01<T> tail;
        private int size;

        public MyDeque() {
            head = null;
            tail = null;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void pushHead(T value) {
            DoubleNode01<T> cur = new DoubleNode01<>(value);
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

        public void pushTail(T value) {
            DoubleNode01<T> cur = new DoubleNode01<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.pre = tail;
                tail.next = cur;
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
                head.pre = null;
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
                tail = tail.pre;
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

    public static class MyDeque01<T> {
        private DoubleNode01<T> head;
        private DoubleNode01<T> tail;
        private int size;

        public MyDeque01() {
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
            DoubleNode01<T> cur = new DoubleNode01<>(value);
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

        public void pushTail(T value) {
            DoubleNode01<T> cur = new DoubleNode01<>(value);
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
                head.pre = null;
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
                tail = tail.pre;
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

    public static void testMyDeque() {
        MyDeque02<Integer> myDeque = new MyDeque02<>();
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

    public static class MyDeque02<T> {
        private DoubleNode01<T> head;
        private DoubleNode01<T> tail;
        private int size;

        public MyDeque02() {
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
            DoubleNode01<T> cur = new DoubleNode01<>(value);
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

        public void pushTail(T value) {
            DoubleNode01<T> cur = new DoubleNode01<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.pre = tail;
                tail.next = cur;
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
                head.pre = null;
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
                tail = tail.pre;
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

    public static Node reverseKGroup(Node head, int k) {
        Node start = head;
        Node end = getKGroupEnd(head, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        Node lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static Node getKGroupEnd(Node head, int k) {
        while (--k != 0 && head != null) {
            head = head.next;
        }
        return head;
    }

    public static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node next;
        Node cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static Node reverseKGroup01(Node head, int k) {
        Node start = head;
        Node end = getKGroupEnd01(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse01(start, end);
        Node lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse01(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static Node getKGroupEnd01(Node start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverse01(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node next;
        Node cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static Node addTwoNumber(Node node1, Node node2) {
        int length1 = listLength(node1);
        int length2 = listLength(node2);
        Node longer = length1 >= length2 ? node1 : node2;
        Node shorter = longer == node1 ? node2 : node1;
        Node curL = longer;
        Node curS = shorter;
        Node last = curL;
        int carry = 0;
        int curSum = 0;
        while (curS != null) {
            curSum = curL.value + curS.value + carry;
            curL.value = (curSum % 10);
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curSum = curL.value + carry;
            curL.value = (curSum % 10);
            carry = curSum / 10;
            last = curL;
            curL = curL.next;
        }
        while (carry != 0) {
            last.next = new Node(1);
        }
        return longer;
    }

    public static int listLength(Node head) {
        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }
        return ans;
    }

    public static Node mergeTwoList(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value <= head2.value ? head1 : head2;
        Node pre = head;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
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
        pre.next = head1 == null ? cur2 : cur1;
        return head;
    }

}
