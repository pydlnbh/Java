package com.algorithm.practice;

import com.algorithm.primary.class06.Code02_TraversalBinaryTree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution027 {

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int value) {
            val = value;
        }
    }

    public static ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                heap.add(node);
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

    private static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }

    public static void f(TreeNode head) {
        if (head == null) {
            return;
        }

        // 先序遍历
        f(head.left);
        // 中序遍历
        f(head.right);
        // 后序遍历
    }

    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(TreeNode head) {
        if (head == null) {
            return;
        }

        in(head.left);
        System.out.print(head.val + " ");
        in(head.right);
    }

    public static void post(TreeNode head) {
        if (head == null) {
            return;
        }

        post(head.left);
        post(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        //              1
        //      2               3
        // 4         5     6           7
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        post(head);
    }
}
