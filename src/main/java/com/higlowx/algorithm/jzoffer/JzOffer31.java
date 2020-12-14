package com.higlowx.algorithm.jzoffer;

/**
 * 整数中1出现的次数
 * <p>
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * <p>
 * 限制：
 * 1 <= n < 2^31
 * <p>
 * leetcode：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * nowcoder：https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6
 *
 * @author Dylan.Li
 * @date 2020/12/14
 */
public class JzOffer31 {

    /**
     * 暴力解法，可能会导致超时
     */
    public int countDigitOne0(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }

    /**
     * 参考题解：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * <p>
     * 以cur所指向的位数的数字为界，将数字分为三个部分：
     * 左边高位组成的数为high,右边低位组成的数为low，cur指向数组的位数为digit;
     * cur从低位依次遍历到高位，累加cur在每一个位置上包含1的个数；
     * 当cur所指的数字为0时，1出现的次数为： high * digit;
     * 当cur所指的数字为1时，1出现的次数为： high * digit + low + 1;
     * 当cur所指的数字为其他数字时，1出现的次数为： (high+1) * digit;
     * <p>
     * case 1: cur=0
     * 2  3   0  4
     * 千位和百位可以选00 01 02....22  十位可以取到1( 形如[00|01..|22]1[0-9] 都是<2304 ) 个位可以选0-9  共有 23 * 10 种排列
     * 当千位和百位取23,如果十位取1 那就是形如 231[0-9] > 2304,所以当千位和百位取23，十位只能能取0，个位取0-4即 2300 2301 2302 2303 2304
     * 但是2301不应该算进来，这个1是 单独  出现在个位的（而11，121,111这种可以被算多次）
     * 即 23*10
     * <p>
     * case 2: cur=1
     * 2  3  1  4
     * 千位和百位可以选00 01 02....22  十位可以取到1 个位可以选0-9  共有 23 * 10 中排列
     * 当千位和百位取23,十位取1，个位可以取0-4 即 2310-2314共5(即低位4+1,1代表取0的可能性)个
     * 即 23 *10 + 4 +1
     * <p>
     * case 3: cur>1 即2-9
     * 2  3  2  4
     * 千位和百位可以选00 01 02....22  十位可以取到1(形如 [00|01...|22]1[0-9] 都是<2324) 个位可以选0-9  共有 23 * 10 种排列
     * 当千位和百位取23,十位取1，个位可以去0-9 即 2310-2319共10个 （其中2311，被计算了两次，分别是从个位和十位分析得到的1次）
     * 即 23 *10 + 10
     */
    public int countDigitOne1(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}