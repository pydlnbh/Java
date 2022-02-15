package com.algorithm.practice;

public class Solution012 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转单链表
     *
     * @param head 单链表头节点
     * @return Node
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     *
     * @param head 链表头结点
     * @return DoubleNode
     */
    public static DoubleNode reverseDoubleLiknedList(DoubleNode head) {
        DoubleNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class NodeT<T> {
        public T value;
        public NodeT next;

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
            NodeT<T> node = new NodeT<>(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
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
            // 在队列中弹出时如果头节点为null, 尾节点也为null
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        public T peek() {
            return head != null ? head.value : null;
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
            NodeT<T> node = new NodeT<>(value);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
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

    public static class DoubleLinkedList<T> {
        private T value;
        private DoubleLinkedList<T> last;
        private DoubleLinkedList<T> next;

        public DoubleLinkedList(T value) {
            this.value = value;
        }
    }

    public static class MyDeque<T> {
        private DoubleLinkedList<T> head;
        private DoubleLinkedList<T> tail;
        private int size;

        public MyDeque() {
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

        public void pushHead(T value) {
            DoubleLinkedList<T> cur = new DoubleLinkedList<>(value);
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
            DoubleLinkedList<T> cur = new DoubleLinkedList<>(value);
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

        public T popHead() {
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

        public T popTail() {
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
//        testNode();
//        testDoubleNode();
//        testMyQueue();
//        testMyStack();
        testMyDeque();
    }

    private static void testMyDeque() {
        MyDeque<Integer> md = new MyDeque<>();
//        md.pushHead(1);
        System.out.println(md.popHead());
        System.out.println(md.getSize());
    }

    private static void testMyStack() {
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

    private static void testMyQueue() {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.offer(2);
        mq.offer(3);
        System.out.println(mq.peek());
        System.out.println(mq.getSize());
        System.out.println(mq.pop());
        System.out.println(mq.peek());
    }

    private static void testDoubleNode() {
        DoubleNode dn = new DoubleNode(1);
        DoubleNode dn1 = new DoubleNode(2);
        DoubleNode dn2 = new DoubleNode(3);
        dn.next = dn1;
        dn1.last = dn;
        dn1.next = dn2;
        dn2.last = dn1;

        printDoubleLinkedList(dn);
        printDoubleLinkedListLast(dn);

        DoubleNode doubleNode = reverseDoubleLiknedList(dn);
        printDoubleLinkedList(doubleNode);
        printDoubleLinkedListLast(doubleNode);
    }

    private static void printDoubleLinkedList(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void printDoubleLinkedListLast(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.last;
        }
        System.out.println();
    }

    private static void testNode() {
        Node n = new Node(1);
        n.next = new Node(2);

        printLinkedList(n);
        Node node = reverseLinkedList(n);
        printLinkedList(node);
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
