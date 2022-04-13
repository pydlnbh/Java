package com.algorithm.primary.practice;

public class Solution004 {

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Node01 {
        public int value;
        public Node01 next;

        public Node01(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

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

    Node pratice(Node head) {
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

    Node practice001(Node head) {
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

    /**
     * 反转单链表练习
     *
     * @param head
     * @return Node
     */
    Node practice002(Node head) {
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
     * 反转双向链表练习
     *
     * @param head
     * @return DoubleNode
     */
    DoubleNode practice001(DoubleNode head) {
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
     * 反转双向链表练习002
     *
     * @param head
     * @return DoubleNode
     */
    DoubleNode practice002(DoubleNode head) {
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
     * 反转双向链表003
     *
     * @param head
     * @return DoubleNode
     */
    DoubleNode practice003(DoubleNode head) {
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

    public static Node removeValue(Node head, int num) {
        // head来到第一个不需要删除的位置, 作为最后链表的头节点
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
     * 删除单链表中的一个数字练习001
     *
     * @param head
     * @param num
     * @return Node
     */
    public static Node removeValuePractice001(Node head, int num) {
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
     * 删除单链表中的一个数字练习002
     *
     * @param head
     * @param num
     * @return Node
     */
    public static Node removeValuePractice002(Node head, int num) {
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

    public static Node01 removeValue001(Node01 head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node01 pre = head;
        Node01 cur = head;
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
}