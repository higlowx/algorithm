package com.higlowx.algorithm.jzoffer;

/**
 * 丑数
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 *
 * leetcode：https://leetcode-cn.com/problems/chou-shu-lcof
 * nowcoder：https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b
 *
 *
 * @author Dylan.Li
 * @date 2020/12/15
 */

public class JzOffer33 {


    /**
     * 分析：
     * 概念解释：
     * 1、质数：指在大于1的自然数中，其约数除了1和它本身之外，没有任何其他的约数（因数，是约数的另外一种称呼），例如2、3、5、7、11、13、17、19...
     * 2、质因子（又称质因数）：指可以整除某个正整数的质数
     *
     * 解题关键：
     * 丑数的递推性质： 丑数只包含因子 2, 3, 5，因此有 “丑数 == 某较小丑数 * 某丑数因子” （例如：10=5×2）
     *
     * 解法：
     * 创建3个指针，two，three，five，分别指向 下次可以乘上 2,3,5 的元素位置
     * 注意，在递推过程中，如果某个较小丑数 * 某丑数因子 生成的 候选丑数 被当选，则该丑数因子的指针必须向后移动，其实就是避免重复丑数的出现
     *
     * 在 3个 候选丑数中，依据从小大大递增的逻辑顺序，需要取出候选值中的最小值作为当前位置最终的选定丑数，对应的丑数因子指针需后移一个单位坐标
     *
     * 时间复杂度O(N)，空间复杂度O(N)，因为开辟了result数组，其大小为n
     */
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] result = new int[n];
        result[0] = 1;
        int two = 0;
        int three = 0;
        int five = 0;
        for (int i = 1; i < n; i++) {
            int twos = result[two] * 2;
            int threes = result[three] * 3;
            int fives = result[five] * 5;
            result[i] = Math.min(twos, Math.min(threes, fives));
            if (result[i] == twos) {
                two++;
            }
            if (result[i] == threes) {
                three++;
            }
            if (result[i] == fives) {
                five++;
            }
        }
        return result[n - 1];
    }
}
