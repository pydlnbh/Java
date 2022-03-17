package com.algorithm.primary.class06;

/**
 * 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Code07_MinDepthOfBinaryTree {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return root.left == null || root.right == null ?  minDepth(root.left) + minDepth(root.right) + 1 : Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        // [2,null,3,null,4,null,5,null,6]
        TreeNode root = new TreeNode(2);
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(6);

        root.right = treeNode;
        treeNode.right = treeNode1;
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;

        int i = minDepth(root);
        System.out.println(i);
    }
}
