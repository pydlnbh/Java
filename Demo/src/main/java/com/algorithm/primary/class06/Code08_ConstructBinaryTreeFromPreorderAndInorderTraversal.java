package com.algorithm.primary.class06;

import java.util.HashMap;

/**
 * 用先序数组和中序数组重建一棵树 Leetcode原题，https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class Code08_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (in[find] != pre[L1]) {
            find++;
        }
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }

    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    private static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = valueIndexMap.get(pre[L1]);
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;
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
        // 1 2 4 5 3 6 7
        // 4 2 5 1 6 3 7
        // 4 5 2 6 7 3 1
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = buildTree1(pre, in);
//        TreeNode treeNode = buildTree2(pre, in);
        post(treeNode);
    }
}
