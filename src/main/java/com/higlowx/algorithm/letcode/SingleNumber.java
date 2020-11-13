package com.higlowx.algorithm.letcode;

/**
 * @author Chris.Li
 * @desc
 * @date 2020/5/14
 */

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arg = new int[]{3,2,2,4,3,-1,4};
        System.out.println(new SingleNumber().singleNumber(arg));
    }
}
