package com.algorithm.primary.class07;

/**
 * 测试链接: https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Code05_IsBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static class Info {
        int min;
        int max;
        boolean succeed;

        public Info(int min, int max, boolean succeed) {
            this.min = min;
            this.max = max;
            this.succeed = succeed;
        }
    }

    public boolean isValidBST(TreeNode node) {
        return process(node).succeed;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return null;
        }

        Info left = process(root.left);
        Info right = process(root.right);

        int min = root.val;
        int max = root.val;
        if (left != null) {
            min = Math.min(left.min, min);
            max = Math.max(left.max, max);
        }
        if (right != null) {
            min = Math.min(right.min, min);
            max = Math.max(right.max, max);
        }

        boolean succeed = false;
        boolean leftIs = left == null ? true : left.succeed;
        boolean rightIs = right == null ? true : right.succeed;
        boolean leftIsBST = left == null ? true : left.max < root.val;
        boolean rightIsBST = right == null ? true : right.min > root.val;
        if (leftIs && rightIs && leftIsBST && rightIsBST) {
            succeed = true;
        }
        return new Info(min, max, succeed);
    }

    public static void main(String[] args) {

    }
}
