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
     * 有执行超时风险
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int reversePairs0(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += nums[i] > nums[j] ? 1 : 0;
            }
        }
        return result;
    }

    /**
     * 方法二：归并排序
     * <p>
     * 概念讲解：归并排序
     * 给定两个顺序数组 array1{1,3,6,8}与array2{0,2,4,9}，将这两个有序数组合并为一个顺序递增数组
     * 声明两个指针i，j，分别指向两个数组的第一个位置，声明一个中间数组temp，用于存储合并后的数组
     * 比较 array1[i] 与 array[j] 的大小关系，如果前者小于后者，则向temp追加前者，i后移一个单位，反之，则追加后者，j后移一个单位
     * 循环往复，直至其中某个数组（或两个都）被遍历完毕，将剩下的未遍历完毕的数组整个追加到temp中，然后结束合并；如果都没剩下，则直接结束合并；
     * 这样temp数组就是我们最终想要得到的顺序递增数组
     * <p>
     * 归并排序的几个核心点在于：
     * 1、合并前的两个数组一定都得是 顺序 的
     * 2、需要中间数组进行合并集的存储
     * 3、需要双指针
     * <p>
     * Q：那么在该题目中，如何使用归并排序来统计数组中逆序对的数量呢？
     * A：利用归并排序 对合并前 两个数组的 顺序 特性，减少逐一比较的资源、时间消耗，在排序的同时，进行逆序对的统计
     */
    public int reversePairs1(int[] nums) {
        int[] temp = new int[nums.length];

        return 0;
    }

    private int reversePairs1(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs1(nums, left, mid, temp);
        int rightCount = reversePairs1(nums, mid + 1, right, temp);
        int mergeCount = mergeAndCount(nums, left, mid, right, temp);
        return leftCount + rightCount + mergeCount;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {


        return 0;
    }


}
