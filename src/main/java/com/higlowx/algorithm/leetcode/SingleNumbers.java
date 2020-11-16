package com.higlowx.algorithm.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Chris.Li
 * @desc
 * @date 2020/4/28
 */

public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] res = new int[2];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i] = iterator.next();
            i++;
        }
        return res;
    }

    public int[] singleNumbers2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int[] res = new int[2];
        return res;
    }
}
