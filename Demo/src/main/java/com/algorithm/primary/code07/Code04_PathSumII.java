package com.algorithm.primary.code07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code04_PathSumII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(root, path, 0, targetSum, ans);
        return ans;
    }

    public void process(TreeNode root, List<Integer> path, int pathSum, int sum, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (root.val + pathSum == sum) {
                path.add(root.val);
                ans.add(copy(path));
                path.remove(path.size() - 1);
            }
        }

        pathSum += root.val;
        path.add(root.val);
        if (root.left != null) {
            process(root.left, path, pathSum, sum, ans);
        }
        if (root.right != null) {
            process(root.right, path, pathSum, sum, ans);
        }
        path.remove(path.size() - 1);
    }

    public List<Integer> copy(List<Integer> path) {
        List<Integer> res = new ArrayList<>();
        for (Integer num : path) {
            res.add(num);
        }
        return res;
    }
}
