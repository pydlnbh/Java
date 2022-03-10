package com.algorithm.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并多个有序链表 Leetcode原题，https://leetcode.com/problems/merge-k-sorted-lists
 *
 * 1. 判断链表数组是否为空
 * 2. 实例化优先队列和比较器
 * 3. 遍历链表数组、如果链表数组不等于空、添加到优先队列中
 * 4. 判断添加后的队列是否为空 (可以用isEmpty或者size == 0)
 * 5. 把队列中第一个节点先拿出来当头、 如果头结点的下个指针不为空、把头结点的下个指针放进队列中
 * 6. 循环遍历队列、把队列中第一个节点弹出、然后让头节点指向它(队列中的第一个节点)、如果它(队列中的第一个节点)不为空、放进队列中
 * 7. 返回头结点
 */
public class Solution025 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class ListComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void testMergeLists() {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(4);
        ListNode node03 = new ListNode(5);
        node01.next = node02;
        node02.next = node03;

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(6);
        node21.next = node22;

        ListNode[] lists = {node01, node11, node21};
        ListNode head = mergeKSortedLists(lists);
        printLinkedList(head);
    }

    public static void main(String[] args) {
//        testMergeLists();
        ListNode listNode = new ListNode();
        ListNode[] lists = {listNode};
        mergeKSortedLists(lists);
    }

    public static class ListNodeComaprator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    /**
     * 1. 判断链表数组是否为空
     * 2. 实例化优先队列和比较器
     * 3. 遍历链表数组、如果链表数组不等于空、添加到优先队列中
     * 4. 判断添加后的队列是否为空 (可以用isEmpty或者size == 0)
     * 5. 把队列中第一个节点先拿出来当头、 如果头结点的下个指针不为空、把头结点的下个指针放进队列中
     * 6. 循环遍历队列、把队列中第一个节点弹出、然后让头节点指向它(队列中的第一个节点)、如果它(队列中的第一个节点)不为空、放进队列中
     * 7. 返回头结点
     *
     * @param lists 链表数组
     * @return ListNode
     */
    public static ListNode mergeKSortedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComaprator());
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list != null) {
                heap.add(list);
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }

        return head;
    }
}
