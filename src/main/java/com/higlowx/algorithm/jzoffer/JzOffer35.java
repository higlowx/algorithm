package com.higlowx.algorithm.jzoffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * @author Dylan.Li
 * @date 2020/12/17
 */

public class JzOffer35 {

    /**
     * 解法一：暴力双层循环
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += nums[i] > nums[j] ? 1 : 0;
            }
        }
        return result;
    }
}
