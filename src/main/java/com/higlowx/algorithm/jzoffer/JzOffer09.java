package com.higlowx.algorithm.jzoffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Dylan.Lee
 * @date 2020/11/18
 * @since
 */

public class JzOffer09 {

    /**
     * 分析：
     * 还是先尝试找一下规律：
     * target = 1
     * 1
     * 共1种
     * target = 2
     * 1 1
     * 2
     * 共2种
     * target = 3
     * 1 1 1
     * 1 2
     * 2 1
     * 3
     * 共4种
     * target = 4
     * 1 1 1 1
     * 1 1 2
     * 1 2 1
     * 1 3
     * 2 1 1
     * 2 2
     * 3 1
     * 4
     * 共8种
     * target = 5
     * 1 1 1 1 1
     * 1 1 1 2
     * 1 1 2 1
     * 1 1 3
     * 1 3 1
     * 1 4
     * 1 2 1 1
     * 1 2 2
     * 2 1 1 1
     * 2 1 2
     * 2 2 1
     * 2 3
     * 3 1 1
     * 3 2
     * 4 1
     * 5
     * 共16种
     * target = 6
     * 1 1 1 1 1 1
     * 1 1 1 1 2
     * 1 1 1 3
     * 1 1 4
     * 1 5
     * 1 2 1 1 1
     * 1 2 1 2
     * 1 2 2 1
     * 1 2 3
     * 1 3 1 1
     * 1 3 2
     * 1 4 1
     * 1 1 2 1 1
     * 1 1 2 2
     * 1 1 3 1
     * 1 1 1 2 1
     * 2 1 1 1 1
     * 2 1 1 2
     * 2 1 3
     * 2 4
     * 2 2 1 1
     * 2 2 2
     * 2 3 1
     * 2 1 2 1
     * 3 1 1 1
     * 3 1 2
     * 3 2 1
     * 3 3
     * 4 1 1
     * 4 2
     * 5 1
     * 6
     * 共32种
     * 整理得知：
     * target从1~6，对应的跳法分别为 1 2 4 8 16 32
     * 可见：f(n) = 2f(n-1)
     */

    /**
     * 一步到位，动态规划+空间优化
     */
    public int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int a = 1, b = 0;
        for (int i = 2; i <= target; i++) {
            b = a * 2;
            a = b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new JzOffer09().jumpFloorII(6));
    }
}
