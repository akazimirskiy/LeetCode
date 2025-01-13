package ru.kazimir.leetcode;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = curr;
        if (nums.length == 1) return max;
        for (int i = 1; i < nums.length; i ++) {
            if (curr < 0) {
                curr = nums[i];
            } else {
                curr += nums[i];
            }
            if (max < curr) max = curr;
        }
        return max;
    }
}
