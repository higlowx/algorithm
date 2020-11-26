package com.higlowx.algorithm.jzoffer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
 * <p>
 * TODO leetcode运行没通过
 * leetcode:https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/submissions/
 * nowcoder:https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 *
 * @author Dylan.Li
 * @date 2020/11/20
 */

public class JzOffer12 {


    /**
     * 1、暴力法，for循环
     * 时间复杂度O(n)
     */
    public double power0(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int abs = (exponent < 0) ? -exponent : exponent;
        //a、这里将res的初值设为base，目的是将1次方的情况单独拎出来,实际上可以非常巧妙的优化掉
        //double res = base;
        //if (abs != 1) {
        //    for (int i = 1; i <= abs; i++) {
        //        res *= base;
        //    }
        //}
        //b、res初值设为1，即base的0次方，不用再判断abs是不是1了
        double res = 1;
        for (int i = 1; i <= abs; i++) {
            res *= base;
        }
        return exponent < 0 ? 1 / res : res;
    }

    /**
     * 快速幂，二进制
     * <p>
     * 分析：
     * a的2n的方可以被拆解，引入数学公式 a的2n次方 = a的n+n次方 = a的n次方 * a的n次方
     * 那么如何将指数exponent快速拆解呢？
     * 我们可以使用exponent的二进制形式
     * 假如exponent=9，即exponent = 0b 0000 1001
     * 我们只是用有效的低四位，8 = 1*2º + 0*2¹ + 0*2² + 1*2³ = 1+0+0+8 = 8;
     * 那么 a的9次方 = a的1次方 * a的8次方
     * 理论上如果exponent越大越复杂，相比方法一，最终的计算次数会越少
     */
    public double power1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int abs = (exponent < 0) ? -exponent : exponent;
        double res = 1;
        int subExponent = 1;
        double subPower = 1;
        int subExponentForThisSubPower = subExponent;
        while (abs != 0) {
            //0b00000011 & 0b00000001 = 0b00000001 = 0o1
            //借助&运算，判断exponent最低位是否=1？是-进行实际计算；否-计算下一次中间指数subExponent、删除最低位
            //如果指数最低位是1，则计算出中间幂，中间幂 = base的（1 * 2的i次幂）次幂
            if ((abs & 1) == 1) {
                //如果曾经计算过中间幂，则可以利用数学公式 （a的n次幂）的m次幂 = a的m*n次幂，直接使用之前的中间幂计算，不用再用base从头计算，以减少计算次数
                if (subExponentForThisSubPower < subExponent) {
                    double p = subPower;
                    for (int i = 1; i < (subExponent / subExponentForThisSubPower); i++) {
                        subPower *= p;
                    }
                } else {
                    for (int i = 1; i <= subExponent; i++) {
                        subPower *= base;
                    }
                }
                //缓存本次中间幂的中间指数，用以快速缓存式计算
                subExponentForThisSubPower = subExponent;
                //将中间幂乘进最终结果中
                res *= subPower;
            }
            //计算向左一位位置时的中间指数，即2的[0~n]次幂
            subExponent = subExponent * 2;
            abs >>= 1;
        }
        return exponent < 0 ? 1 / res : res;
    }

    /**
     * 快速幂，二进制分制
     */
    public double power2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        int abs = (exponent < 0) ? -exponent : exponent;
        double res = 1.0;
        while (abs > 0) {
            //如果最低位是1，将base乘进res中
            if ((abs & 1) == 1) {
                res *= base;
            }
            //如果最低位不是1，追加base的值，变为当前值得平方，实际上这一步：直接计算出了后一次匹配到低位1时，当时的中间幂是多少，非常巧妙
            base *= base;
            abs >>= 1;
        }
        return exponent < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(new JzOffer12().power2(2, 3));
        System.out.println(new JzOffer12().power2(2, -2));
    }
}
