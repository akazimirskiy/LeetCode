package ru.kazimir.leetcode;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
        System.out.println(new LongestPalindrome().longestPalindrome("caaaaa"));
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
        System.out.println(new LongestPalindrome().longestPalindrome("ccd"));
        System.out.println(new LongestPalindrome().longestPalindrome("tattarrattat"));
        System.out.println(new LongestPalindrome().longestPalindrome("aaabaaaa"));
        System.out.println(new LongestPalindrome().longestPalindrome("aaaa"));
        System.out.println(new LongestPalindrome().longestPalindrome("bb"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append("#");
        s = sb.toString();
        String max = "";
        for (int i = 1; i < s.length(); i ++) {
            int left = i;
            int right = i;
            while ((left>=0 && right<s.length()) && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max.length()) {
                    max = s.substring(left, right+1);
                }
                left --;
                right ++;
            }
        }
        return max.replace("#", "");
    }
}
