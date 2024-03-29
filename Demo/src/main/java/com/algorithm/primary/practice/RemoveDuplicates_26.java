package com.algorithm.primary.practice;

/**
 * 删除有序数组中的重复项: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates_26 {

    public static int removedup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                nums[++cur] = nums[i];
            }
        }
        return cur + 1;
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static int deleteDup(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static int deleteDupca(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                nums[++cur] = nums[i];
            }
        }
        return ++cur;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int num = deleteDupca(arr);
        System.out.println(num);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
