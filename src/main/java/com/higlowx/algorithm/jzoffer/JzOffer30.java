package com.higlowx.algorithm.jzoffer;

/**
 * 连续子数组的和的最大值（Maximum Sum Subarray）
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * <p>
 * leetcode：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 * @author Dylan.Lee
 * @date 2020/12/10
 */

public class JzOffer30 {

    /**
     * 题目要求时间复杂度为O(N)，我们首先会联想到从头至尾遍历一遍后便会得到结果
     * <p>
     * 这里我们假设 到达array[x]时，此时的最大子数组和 sum[x] = a
     * 向前推一个下标单位，首先我们知道 前一个元素可以记作是 array[x-1]
     * 分析一下 array[x-1]的值，可能会大于零，也可能等于零，当然也可能小于零
     * <p>
     * 我们都知道，在 加法运算中，
     * 一个数a 加上 一个正数b，其和一定大于a；
     * 但是如果一个数a，加上 一个负数b，其和一定小于a
     * 同样的，如果一个数a，加上一个数，其值为0，和一定等于a
     * <p>
     * 根据此题的思路转换一下，假设：到达array[x]时，此时有 最大子数组和 sum[x]
     * 1.如果 array[x-1] > 0，一定有 array[x-1] + array[x] > array[x]，此时sum加上array[x-1]，对最终的sum来说是正贡献，sum会变大
     * 2.如果 array[x-1] < 0，一定有 array[x-1] + array[x] < array[x]，此时sum加上array[x-1]，对最终的sum来说是负贡献，sum会变小
     * 3.如果 array[x-1] = 0，一定有 array[x-1] + array[x] = array[x]，此时sum加上array[x-1]，对最终的sum来说是无影响，sum不变
     * *
     *
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        //定义一个结果值
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //此处理解起来可能比较困难
            //该方法中直接使用nums[i]用来存储从下标i向前推，所有 连续的 正贡献的 相加的 和
            //推至负贡献或无贡献时停止，但是并不是意味着 此次计算之前 的 已经得到过的和 会丢失，因为我们已经使用res存储了起来
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            } else if (nums[i - 1] <= 0) {
                //nums[i] = nums[i];
                //如果nums[i-1]<=0，那么相加的话，其对nums[i]无贡献
            }
            //比较上一次前推停止得到的和 与当前 前推的和 即nums[i]，并进行比较赋值
            if (nums[i] > res) {
                res = nums[i];
            }
        }
        return res;
    }


}
