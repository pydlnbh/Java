package com.algorithm.primary.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并多个有序链表 Leetcode原题，https://leetcode.com/problems/merge-k-sorted-lists
 */
public class Code03_MergeKSortedLists {

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int value) {
            val = value;
        }
    }

    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
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

    private static void testMergeLists() {
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
        ListNode head = mergeKLists(lists);
        printLinkedList(head);
    }

    public static void main(String[] args) {
        testMergeLists();
    }
}
