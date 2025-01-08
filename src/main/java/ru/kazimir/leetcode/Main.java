package ru.kazimir.leetcode;

import ru.kazimir.leetcode.streams.Func;
import ru.kazimir.leetcode.streams.User;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public int maxProfit(int[] prices) {
        Map a = new HashMap<>();
        int profit = 0;
        if (prices.length > 1) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i-1];
                }
            }
        }
        return profit;
    }
    public void rotate(int[] nums, int k) {
        if (nums.length > 1) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, (k % nums.length) - 1);
            reverse(nums, k % nums.length, nums.length - 1);
        }
    }
    private void reverse (int[] nums, int startIndex, int stopIndex) {
        while (startIndex < stopIndex) {
            nums[startIndex] += nums[stopIndex];
            nums[stopIndex] = nums[startIndex] - nums[stopIndex];
            nums[startIndex] = nums[startIndex] - nums[stopIndex];
            startIndex++;
            stopIndex--;
        }
    }
    public boolean containsDuplicate(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
    public int singleNumber(int[] nums) {
        int result = nums[0];
        nums = Arrays.stream(nums).sorted().toArray();
        if ((nums.length == 1) || (nums[0] != nums[1])) {
            result = nums[0];
        } else {
            for (int i = 1; i < nums.length; i++) {
                if ((nums[i - 1] != nums[i])
                        && (((i + 1) >= nums.length) || (nums[i] != nums[i + 1]))) {
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i ++;
            j --;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cursor = head;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
        }
        return head;
    }

    private boolean palindrome(String str) {
        String subStr;
        int index = str.length()%2 == 1 ? str.length()/2 +1 : str.length()/2;
        subStr = (new StringBuilder(str.substring(index, str.length()))).reverse().toString();
        str = str.substring(0, str.length() / 2);
        return str.equals(subStr);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, CloneNotSupportedException {
//        int[] head = {4,5,1,9};
//        int node = 2;
//        (new Main()).deleteNode(new ListNode(node));
//        char[] chars = {'h','e','l','l','o'};
//        (new Main()).reverseString(chars);
//        System.out.println(String.valueOf(chars));



//        int[] prices = {1, 4, 4};
//        System.out.print((new Main()).maxProfit(prices));
//        int[] nums = {1, 2};
//        int k = 3;
//        (new Main()).rotate(nums, k);
//        for (int i = 0; i <nums.length; i ++) {System.out.print(nums[i] + " ");}
//        Arrays.asList(nums).forEach((num)->System.out.print(num + " "));
//        int[] nums = {5, 6, 5, 7, 12};
//        System.out.println((new Main()).containsDuplicate(nums));
//        int[] nums = {1};
//        System.out.println((new Main()).singleNumber(nums));

//        int ert;
//        System.out.println(ert);

        Integer[] empIds = {1, 2, 3, 4};
        List<Integer> ints = Stream.of(empIds).filter(e->e != 3).collect(Collectors.toList());
        System.out.println(ints);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println(executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Done";
            }
        }).get());
        executorService.shutdown();
        Func<Double, Double> square = x->x*x;
        System.out.println(square.calc(5.0));

        Runnable runnable = ()-> {
            System.out.println("Hello from " + Thread.currentThread().getName());
        };
        (new Thread(()->{System.out.println("Hello from " + Thread.currentThread().getName());})).start();
        (new Thread(runnable)).start();

        int i=0;
        ++i;

        String s = "112";
        System.out.println(s + " is a palindrome: " + (new Main()).palindrome(s));;

        Set set = new LinkedHashSet();
        set.add("1");
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set);

        char a = 'a';
        int b = 98;
        System.out.println("1. " + a + b);
        System.out.println("2. " + (a + b));

        int as = 100;
        System.out.println(as--*as--*as--);
        System.out.println(as);
        as = 100;
        System.out.println(as--*as);
        as = 100;
        System.out.println(--as*as);
        int x = 2;
        System.out.println(Math.abs(Math.pow(x, 2) - Math.pow(x+1, 2)));
        String log = "12w*123*34";
        for (int ii = 0; ii < log.length(); ii ++) {
            if (log.charAt(ii) == '*') {

            }
        }
        //System.out.println(log.split("*").length);

        String str1 = "asd.pdf";
        str1.matches(".");
        System.out.println(str1.split("."));

        try {

        } catch (Exception e) {

        } finally {
        }

        double a1, b1, c1;
        a1 = 4.0/0;
        b1 = 0/3.0;
        c1 = 0/0.0;
        System.out.println("a1 = " + a1);
        System.out.println("b1 = " + b1);
        System.out.println("c1 = " + c1);

        Map<String, Integer> map = new HashMap<>();
        map.put("a1", 1);
        map.put("a2", 2);
        map.put("a3", 3);
        map.put("a1", 4);
        System.out.println(map.size());

        List<User> users = new ArrayList<>();
        users.stream().map(User::getName).collect(Collectors.toList());


        Child ch1 = new Child();
        ch1.name = "Child 1";
        ch1.str = Optional.of("ASD");
        Child ch2 = (Child) ch1.clone();
        ch2.name = "Child 2";
        ch2.str = Optional.of("ZXC");
        System.out.println(ch1.name + " " + ch1.str.get());
        System.out.println(ch2.name + " " + ch2.str.get());

        String s1 = new String ("java");
        String s2 = new String ("JAVA");
        System.out.println(s1 = s2);

    }

}
