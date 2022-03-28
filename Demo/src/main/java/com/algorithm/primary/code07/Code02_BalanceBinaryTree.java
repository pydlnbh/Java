package com.algorithm.primary.code07;

// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class Code02_BalanceBinaryTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        private boolean isBanlance;
        private int height;

        public Info(boolean isBanlance, int height) {
            this.height = height;
            this.isBanlance = isBanlance;
        }
    }

    public static boolean isBanlanced(TreeNode root) {
        return process(root).isBanlance;
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }

        Info left = process(root.left);
        Info right = process(root.right);
        boolean isBanlance = left.isBanlance && right.isBanlance && Math.abs(left.height - right.height) < 2;
        int height = Math.max(left.height, right.height) + 1;
        return new Info(isBanlance, height);
    }

    public static void main(String[] args) {

    }
}
