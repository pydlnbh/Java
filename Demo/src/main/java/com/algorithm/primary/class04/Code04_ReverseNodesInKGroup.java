package com.algorithm.primary.class04;

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
        Node start = getKGroupEnd(node, 2);
        System.out.println(start);
    }

}
