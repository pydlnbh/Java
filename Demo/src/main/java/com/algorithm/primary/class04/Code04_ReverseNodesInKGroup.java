package com.algorithm.primary.class04;

/**
 * K个节点的组内逆序调整问题： 给定一个单链表的头节点head，和一个正数k 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
 * 例子: 调整前：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8，k = 3 调整后：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
 *
 * 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Code04_ReverseNodesInKGroup {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        Node start = head;
        Node end = getKGroupEnd(head, k);
        if (end == null) {
            return head;
        }
        // 第一组反转
        head = end;
        reverse(start, end);
        // 上一组的结尾节点
        Node lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static Node getKGroupEnd(Node start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null, next;
        Node cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node node1 = reverseKGroup(node, 2);
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }
    }

}
