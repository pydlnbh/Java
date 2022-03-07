package com.algorithm.primary.class04;

/**
 * 两个链表相加问题 给定两个链表的头节点head1和head2， 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子 4 -> 3 -> 6 2 -> 5 -> 3 返回 6 -> 8 -> 9 解释 634 + 352 = 986
 *
 * 测试链接：https://leetcode.com/problems/add-two-numbers/
 */
public class Code05_AddTwoNumbers {

    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int length1 = listLength(head1);
        int length2 = listLength(head2);
        ListNode longer = length1 >= length2 ? head1 : head2;
        ListNode shorter = longer == head1 ? head2 : head1;
        ListNode curL = longer;
        ListNode curS = shorter;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        while (curS != null) {
            curNum = curL.value + curS.value + carry;
            curL.value = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            curNum = curL.value + carry;
            curL.value = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return longer;
    }

    /**
     * 求链表长度
     *
     * @param head 头结点
     * @return int
     */
    private static int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(8);

        ListNode node2 = new ListNode(8);
        node2.next = new ListNode(7);
        node2.next.next = new ListNode(2);

        ListNode listNode = addTwoNumbers(node1, node2);

        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }

    }

}
