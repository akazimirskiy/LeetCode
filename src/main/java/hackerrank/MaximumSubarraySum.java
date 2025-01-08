package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maximumSum(List.of(3L, 3L, 9L, 9L, 5L), 7));
        System.out.println(maximumSum(List.of(1L, 5L, 9L), 5));
    }

    public static long maximumSum(List<Long> a, long m) {
        a = a.stream().filter(i -> i % m != 0).collect(Collectors.toList());
        if (a.stream().mapToLong(i -> i).anyMatch(i -> i == m-1)) return m-1;

        List<Long> sums = new ArrayList<>(List.of(a.get(0)));
        for (int i = 1; i < a.size(); i ++) {
            sums.add(a.subList(0, i+1).stream().mapToLong(val -> val).sum());
        }

        long maxSumMod = 0;
        long diff = 0;
        for (int i = 0; i < a.size(); i ++) {
            for (int j = 0; j < a.size()-i; j ++) {
                long sum = sums.get(i+j) - diff;
                long mod = sum % m;
                if (mod == m-1) return mod;
                if (mod <= m && maxSumMod < mod) {
                    maxSumMod = mod;
                }
            }
            diff += a.get(i);
        }
        return maxSumMod;
    }
}
