package ru.kazimir.leetcode;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {2,3,-2,4}));//6
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-3,-1,-1}));//3
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-2,0,-1}));//0
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-2}));//-2
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-2, -3}));//6
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-2, 3}));//3
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {-2, -2}));//4
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {2,-5,-2,-4,3}));//24
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int tempCurrMin;
        int currMin = nums[0];
        int currMax = nums[0];
        int max = currMax;
        for (int i = 1; i < nums.length; i++) {
            //tempCurrMin = Math.min(nums[i], Math.min(currMax*nums[i], currMin*nums[i]));
            if (nums[i] <= currMax * nums[i] && nums[i] <= currMin * nums[i]) {
                tempCurrMin = nums[i];
            } else if (currMax * nums[i] <= currMin * nums[i]) {
                tempCurrMin = currMax * nums[i];
            } else {
                tempCurrMin = currMin * nums[i];
            }
            //currMax = Math.max(nums[i], Math.max(currMax*nums[i], currMin*nums[i]));
            if (nums[i] >= currMax * nums[i] && nums[i] >= currMin * nums[i]) {
                currMax = nums[i];
            } else if (currMax * nums[i] >= currMin * nums[i]) {
                currMax = currMax * nums[i];
            } else {
                currMax = currMin * nums[i];
            }
            currMin = tempCurrMin;
            max = currMax > max ? currMax : max;
        }
        return max;
    }
}
