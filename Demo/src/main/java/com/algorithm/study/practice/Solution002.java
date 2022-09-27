package com.algorithm.study.practice;

public class Solution002 {

    public static void main(String[] args) {
        basicTest();
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

}
