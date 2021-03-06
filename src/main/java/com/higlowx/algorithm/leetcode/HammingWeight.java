package com.higlowx.algorithm.leetcode;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * <p>
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 *
 * @author Dylan.Lee
 * @date 2020/6/2
 * @since
 */

public class HammingWeight {

    /**
     * 逐位判断,根据n与1做按位与，有且仅有1&1=1,
     * 时：O(㏒₂n),㏒₂n代表数字n最高位1的所在的位数（如㏒₂4=2，㏒₂16=4）
     * 空：O(1)
     *
     * @param n
     * @return
     */
    public int hammingWeight0(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            //无符号右移 >>>，没有<<<这种，因为左移都是低位补零，没有符号位的区别
            n = n >>> 1;
        }
        return count;
    }

    /**
     *巧用 n&n-1
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight0(19));
        System.out.println(new HammingWeight().hammingWeight1(19));

    }
}
