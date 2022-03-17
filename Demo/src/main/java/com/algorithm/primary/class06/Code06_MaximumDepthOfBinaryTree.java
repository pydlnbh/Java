package com.algorithm.primary.class06;

/**
 * 返回一棵树的最大深度 Leetcode原题，https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class Code06_MaximumDepthOfBinaryTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
