package ru.kazimir.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int x=1;
        for(int y=x ; y < nums.length; y++) {
            if(nums[y] > nums[x-1]) {
                nums[x++]=nums[y];
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        System.out.print("k = " + (new RemoveDuplicates()).removeDuplicates(nums) + "; nums = " + Arrays.toString(nums));
    }
}
