package com.higlowx.algorithm.jzoffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author Dylan.Lee
 * @date 2020/11/17
 * @since
 */

public class JzOffer08 {

    /**
     * 分析：
     * <p>
     * 先找规律：
     * target = 1
     * * 1
     * 共1种
     * <p>
     * target = 2
     * * 1 1
     * * 2
     * 共2种
     * <p>
     * target = 3
     * * 1 1 1
     * * 1 2
     * * 2 1
     * 共3种
     * <p>
     * target = 4
     * * 1 1 1 1
     * * 1 1 2
     * * 1 2 1
     * * 2 1 1
     * * 2 2
     * 共5种
     * <p>
     * target = 5
     * * 1 1 1 1 1
     * * 1 1 1 2
     * * 1 1 2 1
     * * 1 2 1 1
     * * 1 2 2
     * * 2 1 1 1
     * * 2 1 2
     * * 2 2 1
     * 共8种
     * <p>
     * 将以上结果整理，target等于 1 2 3 4 5时，分别有 1 2 3 5 8种跳法
     * 由此可以得到：跳到n级台阶的方法数 = 跳到n-1级台阶的方法数 + 跳到n-2级的方法数
     * 我们惊奇的发现这与“斐波那契数列”几乎相同
     * 唯一的不同点在于其第1、2两位为分别是 1 2，而不是题目7中的 1 1
     * Q：如何弥补其中的不同才能使用一样的解法呢
     * A：答案就是将第0个的值设置为 1 ，区别于题目7中的 0 1 1，本题为 1 1 2
     * 剩下的就不再赘述了，以下将只给出递归、动态规划两种解法，其他的解法可以参照{@link com.higlowx.algorithm.jzoffer.JzOffer07}
     */

    /**
     * 1、递归
     *
     * @param target
     * @return
     */
    public int jumpFloor0(int target) {
        if (target <= 1) {
            return 1;
        }
        return jumpFloor0(target - 1) + jumpFloor0(target - 2);
    }


    /**
     * 2、动态规划
     */
    public int jumpFloor1(int target) {
        int[] cache = new int[target + 1];
        cache[0] = cache[1] = 1;
        for (int i = 2; i <= target; ++i) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[target];
    }

    public static void main(String[] args) {
        System.out.println(new JzOffer08().jumpFloor1(4));
    }
}
