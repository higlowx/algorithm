package com.higlowx.algorithm.letcode;

/**
 * @author Chris.Li
 * @desc
 * @date 2020/4/24
 */

public class ReversePairs {

    public int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += nums[i] > nums[j] ? 1 : 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int res = new ReversePairs().reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(res);
    }

}
