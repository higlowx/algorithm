package com.dylanlee.algorithm;// 两数之和
//
//  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//  示例:
//
//  给定 nums = [2, 7, 11, 15], target = 9
//
//  因为 nums[0] + nums[1] = 2 + 7 = 9
//  所以返回 [0, 1]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Chris.Li
 * @desc
 * @date 2020/4/23
 */

public class TwoSum {

    //暴力循环
    public int[] twoSum1(int[] nums, int target) {
        int left = 0;
        int maxIdx = nums.length - 1;
        int right = maxIdx;
        while (left != maxIdx) {
            if (left == right) {
                left++;
                right = maxIdx;
            }
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            }
            right--;
        }
        throw new IllegalArgumentException();
    }

    //一遍哈希
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> tab = new HashMap<>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            if (tab.containsKey(target - nums[i])) {
                return new int[]{tab.get(target - nums[i]), i};
            }
            tab.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] res = new TwoSum().twoSum2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }

}
