package com.higlowx.algorithm.jzoffer;

import java.util.HashSet;

/**
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * leetcode：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * nowcoder：https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b
 *
 * @author Dylan.Li
 * @date 2021/1/12
 */

public class JzOffer42 {

    /**
     * 采用hash表实现随机检索
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<Integer>(nums.length);
        int dif = 0;
        for (int num : nums) {
            dif = target - num;
            if (set.contains(dif)) {
                return new int[]{num, dif};
            }
            set.add(num);
        }
        return new int[]{};
    }

    /**
     * 采用首位双指针
     * 关键：该数组为有序递增数组，因为有序，所以线性的单向指针移动不会丢失正解集！！
     * 时间复杂度O(N)，空间复杂度相较前者，降为O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int curSum = 0;
        while (left < right) {
            curSum = nums[left] + nums[right];
            if (curSum < target) {
                left++;
            } else if (curSum > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
