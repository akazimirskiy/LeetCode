package ru.kazimir.leetcode;

public class LongestSubstringWithAtMost2 {

    public static void main(String[] args) {
        var obj = new LongestSubstringWithAtMost2();
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct("eceba"));//3
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct("ccaabbb"));//5
        //101
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct("abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX"));//5
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] uni = new int[52];
        int start = 0;
        int max = 0;
        int count = 0;
        for (int end = 0; end < s.length(); end ++) {
            char k = s.charAt(end);
            int index = (k >= 'a') && (k <= 'z') ? k - 'a' : k - 'A' + 26;
            if (uni[index] == 0) {
                count ++;
            }
            uni[index]++;
            while(count > 2) {
                k = s.charAt(start);
                index = (k >= 'a') && (k <= 'z') ? k - 'a' : k - 'A' + 26;
                uni[index]--;
                if (uni[index] == 0) {
                    count --;
                }
                start ++;
            }
            if (max < end-start+1) {
                max = end - start + 1;
            }
        }
        return max;
    }
}
