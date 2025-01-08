package ru.kazimir.leetcode;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9,20};//10
        int[] nums2 = {1};//2
        int[] nums3 = {2,1};//3
        int[] nums4 = {1,2,6,3,5,4};//7
        int[] nums5 = {-1,4,2,1,9,10};//3

        System.out.println((new FirstMissingPositive()).firstMissingPositive4(nums1));
        System.out.println((new FirstMissingPositive()).firstMissingPositive4(nums2));
        System.out.println((new FirstMissingPositive()).firstMissingPositive4(nums3));
        System.out.println((new FirstMissingPositive()).firstMissingPositive4(nums4));
        System.out.println((new FirstMissingPositive()).firstMissingPositive3(nums1));
        System.out.println((new FirstMissingPositive()).firstMissingPositive3(nums2));
        System.out.println((new FirstMissingPositive()).firstMissingPositive3(nums3));
        System.out.println((new FirstMissingPositive()).firstMissingPositive3(nums4));

        System.out.println((new FirstMissingPositive()).firstMissingPositive(nums1));
        System.out.println((new FirstMissingPositive()).firstMissingPositive(nums2));
        System.out.println((new FirstMissingPositive()).firstMissingPositive(nums3));
        System.out.println((new FirstMissingPositive()).firstMissingPositive(nums4));
        System.out.println((new FirstMissingPositive()).firstMissingPositive(nums5));
    }

    public int firstMissingPositive4(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1) {
                return 1;
            } else {
                return nums[0]+1;
            }
        }
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                nums1[nums[i]-1] = nums[i];
            }
        }
        for (int i = 0; i < nums1.length; i ++) {
            if (nums1[i] != i+1) {
                return i+1;
            }
        }
        if (nums[0] == nums.length) {
            return nums.length+1;
        }
        return nums.length+1;
    }

    public int firstMissingPositive3(int[] nums) {
        int last = 0;
        if (nums.length == 1) {
            if (nums[0] != 1) {
                return 1;
            } else {
                return nums[0]+1;
            }
        }
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] >= 0 && nums[i] < nums.length) {
                nums1[nums[i]] = nums[i];
            } else if (nums[i] == nums.length) {
                last = nums[i];
            }
        }
        for (int i = 0; i < nums1.length; i ++) {
            if (nums1[i] != i) {
                return i;
            }
        }
        if (nums[0] == nums.length || last == nums.length) {
            return nums.length+1;
        }
        return nums.length;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1) {
                return 1;
            } else {
                return nums[0]+1;
            }
        }
        for (int i = nums.length; i >= 0; i --) {
            int a = nums[i-1];
            if (a != i) {
                if (a < 0) continue;
                if (a > nums.length) continue;
                int indexB = a-1;
                int b = nums[a-1];
                int backup = a;
                a = b;
                b = backup;
                nums[i-1] = a;
                nums[indexB] = b;
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        if (nums[0] == nums.length) {
            return nums.length+1;
        }
        return nums.length+1;
    }
}
