package com.algorithm.primary.class06;

/**
 * 判断两颗树是否结构相同 Leetcode原题，https://leetcode.com/problems/same-tree
 */
public class Code04_SameTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null ^ t2 == null) {
            return false;
        }
        if (t1 == null && t2 == null) {
            return true;
        }
        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        t1.left = treeNode1;
        t1.right = treeNode2;

        TreeNode t2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        t2.left = treeNode3;
        t2.right = treeNode4;

        boolean sameTree = isSameTree(t1, t2);
        System.out.println(sameTree);
    }
}
