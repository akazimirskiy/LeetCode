package ru.kazimir.leetcode;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi("42"));//42
        System.out.println(new StringToIntegerAtoi().myAtoi(" -042"));//-42
        System.out.println(new StringToIntegerAtoi().myAtoi("1337c0d3"));//1337
        System.out.println(new StringToIntegerAtoi().myAtoi("0-1"));//0
        System.out.println(new StringToIntegerAtoi().myAtoi("words and 987"));//0
        System.out.println(new StringToIntegerAtoi().myAtoi("-+12"));//0
        System.out.println(new StringToIntegerAtoi().myAtoi("2147483648"));//2147483647
        System.out.println(new StringToIntegerAtoi().myAtoi("-2147483647"));//-2147483647
        System.out.println(new StringToIntegerAtoi().myAtoi("20000000000000000000"));//2147483647
        System.out.println(new StringToIntegerAtoi().myAtoi("-91283472332"));//-2147483648
    }

    public int myAtoi(String s) {
        String numberStr = s.trim();
        if (s.isEmpty() || s.equals("-") || s.equals("+")) {
            return 0;
        }
        int sign = 1;
        if (numberStr.startsWith("-")) {
            sign = -1;
            numberStr = numberStr.substring(1);
        } else if (numberStr.startsWith("+")) {
            numberStr = numberStr.substring(1);
        }
        while (numberStr.startsWith("0")) {
            numberStr = numberStr.substring(1);
        }
        short length = 0;
        while (length < numberStr.length() && Character.isDigit(numberStr.charAt(length))) {
            length ++;
        }
        numberStr = numberStr.substring(0, length);
        long res = 0L;
        if (numberStr.length() > 10) {
            if (sign == -1) {
                res = Integer.MIN_VALUE;
            } else {
                res = Integer.MAX_VALUE;
            }
        }
        int index = 0;
        while (index < length && (res != Integer.MIN_VALUE && res != Integer.MAX_VALUE)) {
            int digit = numberStr.charAt(length - 1 - index) - '0';
            res = res + digit * (long)Math.pow(10, index);
            index++;
            if (res > Integer.MAX_VALUE) {
                if (sign == -1) {
                    res = Integer.MIN_VALUE;
                } else {
                    res = Integer.MAX_VALUE;
                }
            }
        }
        return sign*(int)res;
    }
}
