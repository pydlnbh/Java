package com.algorithm.primary.class04;

/**
 * 两个有序链表的合并 给定两个有序链表的头节点head1和head2， 返回合并之后的大链表，要求依然有序
 * 例子 1 -> 3 -> 3 -> 5 -> 7 2 -> 2 -> 3 -> 3-> 7 返回 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
 *
 * 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 */
public class Code06_MergeTwoSortedLinkedList {

    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.value <= head2.value ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
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
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static void main(String[] args) {

    }

}
