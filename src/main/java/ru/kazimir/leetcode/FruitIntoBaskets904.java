package ru.kazimir.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets904 {

    public static void main(String[] args) {
        FruitIntoBaskets904 f = new FruitIntoBaskets904();
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(f.totalFruit(arr));
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = start; end < fruits.length; end ++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);
            while (basket.size() > 2) {
                int fruitQuantity = basket.get(fruits[start]) - 1;
                if (fruitQuantity == 0) {
                    basket.remove(fruits[start]);
                } else {
                    basket.put(fruits[start],  fruitQuantity);
                }
                start ++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
