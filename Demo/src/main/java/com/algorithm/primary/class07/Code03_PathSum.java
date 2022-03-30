package com.algorithm.primary.class07;

public class Code03_PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        isSum = false;
        process(root, 0, targetSum);
        return isSum;
    }

    private static void process(TreeNode root, int preSum, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val + preSum == sum) {
                isSum = true;
            }
            return;
        }

        preSum += root.val;
        if (root.left != null) {
            process(root, preSum, sum);
        }
        if (root.right != null) {
            process(root, preSum, sum);
        }
    }

    public static void main(String[] args) {

    }
}
