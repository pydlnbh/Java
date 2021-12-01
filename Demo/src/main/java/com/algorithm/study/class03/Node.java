package com.algorithm.study.class03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 单项链表的反转
 * 2. 把链表中给定的值删除
 */
public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{value = " + value +
                ", next=" + next +
                '}';
    }

    /**
     * 反转单链表
     *
     * @param head 链表头指针
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }

            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
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


    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node = genRanLinkedList(10, 4);
        printList(node);

        Node node1 = removeValue(node, 4);

        System.out.println("-------------");
        printList(node1);
    }
}
