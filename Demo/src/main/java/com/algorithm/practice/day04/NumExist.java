package com.algorithm.practice.day04;

public class NumExist {
    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;
        int index = search(nums, target);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        // 判断边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;   // 最左边的下标
        int right = nums.length - 1;    // 最右边的下标
        int pivot = 0;  // 中心点

        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else if (nums[pivot] < target){
                left = pivot + 1;
            } else {
                return -1;
            }
        }

        return -1;
    }
}
