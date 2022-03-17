package com.algorithm.primary.class06;

/**
 * 判断一棵树是否是镜面树 Leetcode原题 https://leetcode.com/problems/symmetric-tree
 */
public class Code05_SymmetricTree {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null ^ t2 == null) {
            return false;
        }
        if (t1 == null ^ t2 == null) {
            return true;
        }
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {

    }
}
