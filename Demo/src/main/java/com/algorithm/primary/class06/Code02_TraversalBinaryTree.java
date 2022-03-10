package com.algorithm.primary.class06;

public class Code02_TraversalBinaryTree {

    public static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int value) {
            val = value;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    /**
     * 先序遍历: 根左右
     *
     * @param head 根结点
     */
    public static void preorderTraversal(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preorderTraversal(head.left);
        preorderTraversal(head.right);
    }

    /**
     * 中序遍历: 左根右
     *
     * @param head 根结点
     */
    public static void inorderTraversal(Node head) {
        if (head == null) {
            return;
        }
        inorderTraversal(head.left);
        System.out.print(head.val + " ");
        inorderTraversal(head.right);
    }

    /**
     * 后序遍历: 左右根
     *
     * @param head 根结点
     */
    public static void postorderTraversal(Node head) {
        if (head == null) {
            return;
        }
        postorderTraversal(head.left);
        postorderTraversal(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        //              1
        //      2               3
        // 4         5     6           7
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        preorderTraversal(head);
        System.out.println();
        inorderTraversal(head);
        System.out.println();
        postorderTraversal(head);
    }
}
