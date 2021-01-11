package com.higlowx.algorithm.jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * 1 <= target <= 10^5
 * <p>
 * <p>
 * leetcode：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * nowcoder：https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe
 *
 * @author Dylan.Li
 * @date 2020/12/28
 */

public class JzOffer41 {

    /**
     * 滑动窗口
     */
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        if (target < 3) {
            return result.toArray(new int[result.size()][]);
        }
        int left = 1, right = 2, sum = 3;
        //int  leftLimit = (target - 1) / 2;
        //while (left < right && left <= leftLimit && right < target) {
        //改用以上边界，执行耗时会降低，虽然会减少比较的次数
        while (left < right && right < target) {
            if (sum == target) {
                int[] res = new int[right - left + 1];
                int idx = 0;
                for (int i = left; i <= right; i++) {
                    res[idx] = i;
                    idx++;
                }
                result.add(res);
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new JzOffer41().findContinuousSequence(15)));
    }
}
