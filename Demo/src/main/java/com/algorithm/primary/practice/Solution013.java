package com.algorithm.primary.practice;

public class Solution013 {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 两个链表相加
     */
    public static Node addTwoNode(Node head1, Node head2) {
        int len1 = getNodeLength(head1);
        int len2 = getNodeLength(head2);
        Node longer = len1 >= len2 ? head1 : head2;
        Node shorter = longer == head1 ? head2 : head1;
        Node curL = longer;
        Node curS = shorter;
        Node last = curL;
        int carry = 0;
        int carryNum = 0;
        while (curL != null && curS != null) {
            carryNum = curL.value + curS.value + carry;
            curL.value = (carryNum % 10);
            carry = carryNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            carryNum = curL.value + carry;
            curL.value = (carryNum % 10);
            carry = carryNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new Node(1);
        }
        return longer;
    }

    public static int getNodeLength(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static Node addTwoNode01(Node head1, Node head2) {
        int len1 = getNodeLength(head1);
        int len2 = getNodeLength(head2);
        Node longer = len1 >= len2 ? head1 : head2;
        Node shorter = longer == head1 ? head2 : head1;
        Node curL = longer;
        Node curS = shorter;
        Node last = curL;
        int carry = 0;
        int carryNum = 0;
        while (curS != null) {
            carryNum = curL.value + curS.value + carry;
            curL.value = (carryNum % 10);
            carry = carryNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            carryNum = curL.value + carry;
            curL.value = (carryNum % 10);
            carry = carryNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new Node(1);
        }
        return longer;
    }

    public static Node mergeTwoList(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value <= head2.value ? head1 : head2;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = head;
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

    public static Node addTwoNumber(Node head1, Node head2) {
        int len1 = getNodeLength01(head1);
        int len2 = getNodeLength01(head2);
        Node longer = len1 >= len2 ? head1 : head2;
        Node shorter = longer == head1 ? head2 : head1;
        Node curL = longer;
        Node curS = shorter;
        int carry = 0;
        int carryNum = 0;
        Node last = curL;
        while (curS != null) {
            carryNum = curS.value + curL.value + carry;
            curL.value = (carryNum % 10);
            carry = carryNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            carryNum = curL.value + carry;
            curL.value = (carryNum % 10);
            carry = carryNum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new Node(1);
        }
        return longer;
    }

    public static int getNodeLength01(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static Node mergeTwoList01(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value <= head2.value ? head1 : head2;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = head;
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
