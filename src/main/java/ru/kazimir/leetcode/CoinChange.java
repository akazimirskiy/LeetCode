package ru.kazimir.leetcode;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[] {1,2,5}, 100));//20
        System.out.println(new CoinChange().coinChange(new int[] {2,5,10,1}, 27));//4
        System.out.println(new CoinChange().coinChange(new int[] {5, 1}, 7));//3
        System.out.println(new CoinChange().coinChange(new int[] {1,2,5}, 11));//3
        System.out.println(new CoinChange().coinChange(new int[] {2}, 3));//-1
        System.out.println(new CoinChange().coinChange(new int[] {186,419,83,408}, 6249));//20
    }

    public int coinChange(int[] coins, int amount) {
        return countStep(coins, amount, new int[amount]);
    }

    private int countStep(int[] coins, int remainingAmount, int[] amounts) {
        if (remainingAmount < 0) return -1;
        if (remainingAmount == 0) return 0;
        if (amounts[remainingAmount-1] != 0) return amounts[remainingAmount-1];
        int countLevel = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i ++) {
            int count = countStep(coins, remainingAmount - coins[i], amounts);
            if (count == -1) continue;
            if (countLevel > count + 1) countLevel = count+1;
        }
        countLevel = countLevel == Integer.MAX_VALUE ? -1 : countLevel;
        amounts[remainingAmount-1] = countLevel;
        return countLevel;
    }
}
