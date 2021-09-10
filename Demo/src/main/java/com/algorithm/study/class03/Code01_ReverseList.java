package com.algorithm.study.class03;

import java.util.ArrayList;
import java.util.List;

public class Code01_ReverseList {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        int value;
        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int length = 5;
        int value = 100;
        int testTimes = 1;

        System.out.println("test begin");

        for (int i = 0; i < testTimes; i++) {
            Node node1 = genRanLinkedList(length, value);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);

            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            Node node2 = genRanLinkedList(length, value);
            List<Integer> list2 = getLinkedListOriginOrder(node2);
            node2 = testReverseLinkedList(node2);
            if (!checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }

            DoubleNode node3 = genRanDoubleList(length, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = genRanDoubleList(length, value);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = reverseDoubleList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }
        }

        System.out.println("test finish!");
    }

    /**
     * 反转单链表
     *
     * @param head 单链表头指针
     */
    public static Node reverseLinkedList(Node head) {
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

    /**
     * 反转双向链表
     *
     * @param head 双向链表头指针
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

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
     * 测试反转单链表
     *
     * @param head 单链表头指针
     */
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        ArrayList<Node> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        int N = list.size();

        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }

        return list.get(N - 1);
    }

    /**
     * 测试双向链表
     *
     * @param head 双向链表头指针
     */
    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<DoubleNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();

        for (int i = 0; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.pre = null;
            cur.next = pre;
            pre.pre = cur;
            pre = cur;
        }

        return list.get(N - 1);
    }

    /**
     * 生成随机单向链表
     *
     * @param length 链表长度
     * @param value  链表内容
     */
    public static Node genRanLinkedList(int length, int value) {
        int size = (int) (Math.random() * (length + 1));
        if (size == 0) {
            return null;
        }

        size--;

        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;

        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 生成随机双向链表
     *
     * @param length 链表长度
     * @param value  链表内容
     */
    public static DoubleNode genRanDoubleList(int length, int value) {
        int size = (int) (Math.random() * (length + 1));
        if (size == 0) {
            return null;
        }

        size--;

        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;

        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 检查反转链表
     *
     * @param origin    源链表
     * @param head 链表头指针
     */
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }

        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.pre;
        }
        return true;
    }
}
