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
        Node reverseNode = reverseList01(node);

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
        DoubleNode doubleNode = reverseDoubleList01(dn0);

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

}
