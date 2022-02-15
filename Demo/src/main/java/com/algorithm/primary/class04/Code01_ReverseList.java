package com.algorithm.primary.class04;

/**
 * 反转单链表和双链表
 */
public class Code01_ReverseList {

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
     * @param head 头节点
     * @return Node
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null, next;
        while (head != null) {
            // 先记住下个节点
            next = head.next;
            // 让当前节点指向上一个节点，头节点指向null
            head.next = pre;
            // pre节点指向当前head节点
            pre = head;
            // head指向当前next节点
            head = next;
        }
        // 返回pre(反转后的头节点)
        return pre;
    }

    /**
     * 反转双向列表
     *
     * @param head 头节点
     * @return DoubleNode
     */
    public static DoubleNode reverseDoubleNode(DoubleNode head) {
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

    public static void main(String[] args) {
        // 基础测试
        basicTest();
    }

    private static void basicTest() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);

        // 打印链表
        printNode(node);

        System.out.print("反转链表之后: ");
        // 反转链表
        Node reverseNode = reverseLinkedList(node);

        // 打印链表
        printNode(reverseNode);

        DoubleNode dn0 = new DoubleNode(1);
        DoubleNode dn1 = new DoubleNode(2);
        DoubleNode dn2 = new DoubleNode(3);
        dn0.next = dn1;
        dn1.last = dn0;
        dn1.next = dn2;
        dn2.last = dn1;

        printDoubleNode(dn0);

        printDoubleNodeLast(dn0);

        // 反转链表
        DoubleNode doubleNode = reverseDoubleNode(dn0);

        System.out.println("=========反转后=========");

        printDoubleNode(doubleNode);

        printDoubleNodeLast(doubleNode);
    }

    private static void printDoubleNodeLast(DoubleNode head) {
        System.out.println("向前遍历");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.last;
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
}
