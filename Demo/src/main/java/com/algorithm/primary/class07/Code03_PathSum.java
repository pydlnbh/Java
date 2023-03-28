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
            process(root.left, preSum, sum);
        }
        if (root.right != null) {
            process(root.right, preSum, sum);
        }
    }

    public static class Info {
        boolean isTrue;

        public Info(boolean l) {
            isTrue = l;
        }
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Info info = new Info(false);
        process1(root, 0, targetSum, info);
        return info.isTrue;
    }

    public void process1(TreeNode root, int sum, int targetSum, Info info) {
        if (root.left == null && root.right == null) {
            if (root.val + sum == targetSum) {
                info.isTrue = true;
            }
            return;
        }

        sum += root.val;
        if (root.left != null) {
            process1(root.left, sum, targetSum, info);
        }

        if (root.right != null) {
            process1(root.right, sum, targetSum, info);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(11);
        TreeNode left3 = new TreeNode(7);
        TreeNode right3 = new TreeNode(2);
        head.left = left1;
        left1.left = left2;
        left1.right = null;
        left2.left = left3;
        left3.left = null;
        left3.right = null;
        left2.right = right3;
        right3.left = null;
        right3.right = null;

        TreeNode right1 = new TreeNode(8);
        TreeNode rLeft2 = new TreeNode(13);
        TreeNode rRight2 = new TreeNode(4);
        TreeNode rRight3 = new TreeNode(1);
        head.right = right1;
        right1.left = rLeft2;
        rLeft2.left = null;
        rLeft2.right = null;
        right1.right = rRight2;
        rRight2.left = null;
        rRight2.right = rRight3;
        rRight3.left = null;
        rRight3.right = null;

        boolean ans = new Code03_PathSum().hasPathSum(head, 22);
        System.out.println(ans);

        boolean ans1 = new Code03_PathSum().hasPathSum1(head, 22);
        System.out.println(ans1);
    }
}
