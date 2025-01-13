package ru.kazimir.leetcode;

public class BestTimeToBuyAndSell {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSell().maxProfit(new int[] {7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int max = prices[prices.length-1];
        int maxDeal = 0;
        for (int i = prices.length-2; i >= 0; i --) {
            if (maxDeal < max - prices[i]) maxDeal = max - prices[i];
            if (max < prices[i]) max = prices[i];
        }
        return maxDeal;
    }
}
