package com.saddy.javatest;

import java.util.HashSet;
import java.util.Set;

public class FindSecondHighest {
    public static void main(String[] args) {
        // 3, 2, 9, 8
        int[] nums = { };
        System.out.println(find2ndHighestNumber(nums));;
    }
    static int find2ndHighestNumber(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            System.out.println("Can not find 2nd Highest");
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        if (set.size() == 1) {
            System.out.println("Can not find 2nd Highest");
            return 0;
        }
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest)
                secondHighest = num;
        }
        return secondHighest;
    }
}
