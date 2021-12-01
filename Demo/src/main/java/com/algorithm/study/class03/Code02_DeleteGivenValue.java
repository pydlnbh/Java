package com.algorithm.study.class03;

/**
 * 删除链表中指定的数值
 */
public class Code02_DeleteGivenValue {
    public static void main(String[] args) {
        int testTimes = 1000;
        int length = 100;
        int value = 100;
        boolean flag = true;
        // 开始测试
        for (int i = 0; i < testTimes; i++) {
            Node head = genRanLinkedList(length, value);
            int val = (int) (Math.random() * (value + 1));
            Node node = removeValue(head, val);
            flag = hasValue(node, val);
            if (!flag) {
                System.out.println(val);
                printNode(node);
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "yes" : "no");
    }

    /**
     * 生成随机单链表
     *
     * @param length 链表长度
     * @param value 链表值
     * @return Node
     */
    public static Node genRanLinkedList(int length, int value) {
        // 生成链表随机长度 0 - length
        int size = (int) (Math.random() * (length + 1));
        if (size == 0) {
            return null;
        }
        size--;
        // 生成头节点
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

    /**
     * 打印单链表
     *
     * @param head 链表头
     */
    public static void printNode(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 判断是否还有该值
     *
     * @param head 单链表
     * @param num 数值
     * @return
     */
    public static boolean hasValue(Node head, int num) {
        while (head != null) {
            if (head.value == num) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 删除链表中指定的数值
     *
     * @param head 链表头指针
     * @param num 数值
     * @return Node 单链表
     */
    public static Node removeValue(Node head, int num) {
        // 如果头指针为指定的值，头指针改为下一个指针
        while (head != null) {
            // 如果头节点的value值不等于指定的值
            if (head.value != num) {
                // 跳出循环
                break;
            }
            //
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            // 如果当前指针的值等于指定的值
            if (cur.value == num) {
                // 前一个指针指向下一个节点
                pre.next = cur.next;
            } else {
                // 不等于则让cur对象赋值pre对象
                pre = cur;
            }
            // 往下遍历
            cur = cur.next;
        }
        // 返回头节点
        return head;
    }
}
