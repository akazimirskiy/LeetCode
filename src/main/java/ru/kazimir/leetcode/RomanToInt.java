package ru.kazimir.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> commonChars = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        Map<Character, List<Character>> complexChars = Map.ofEntries(
                Map.entry('I', Arrays.asList('V', 'X')),
                Map.entry('X', Arrays.asList('L', 'C')),
                Map.entry('C', Arrays.asList('D', 'M')));
        boolean minusDecimal = false;
        int res = 0;
        char[] charString = s.toCharArray();
        for (int i = 0; i < charString.length; i++) {
            if (!minusDecimal
                    && (i < charString.length - 1)
                    && (complexChars.containsKey(charString[i]))
                    && (complexChars.get(charString[i]).contains(charString[i + 1]))) {
                minusDecimal = true;
            } else {
                if (minusDecimal) {
                    minusDecimal = false;
                    res += (commonChars.get(charString[i]) - commonChars.get(charString[i - 1]));
                } else {
                    res += commonChars.get(charString[i]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println((new RomanToInt()).romanToInt("MCMXCIV"));
    }
}
