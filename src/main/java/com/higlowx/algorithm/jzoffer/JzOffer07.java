package com.higlowx.algorithm.jzoffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * <p>
 * 0 1 2 3 4 5 6 7  8  9  10
 * 0 1 1 2 3 5 8 13 21 34 55
 *
 * @author Dylan.Lee
 * @date 2020/11/16
 * @since
 */

public class JzOffer07 {

    /**
     * 1、递归法
     * 缺点：有很多重复计算
     *
     * 时间复杂度：
     * n=0|1|2 => O(1)
     * n=3 =>
     */
    public int fibonacci0(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 | n == 2) {
            return 1;
        }
        return fibonacci0(n - 1) + fibonacci0(n - 2);
    }

    /**
     * 2、递归+数组
     * 避免方法一中的重复计算
     * 执行速度从519ms升级为10ms，执行速度50倍与方法1
     * 缺点：空间复杂度O(n)的
     */
    int[] arr;

    public int fibonacci1(int n) {
        if (arr == null) {
            arr = new int[n + 1];
        }
        int v;
        //如果
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //如果数组下标位置的值不等于0，说明已经设置了值，则直接从数组中取
        if ((v = arr[n]) != 0) {
            return v;
        }
        v = fibonacci1(n - 2) + fibonacci1(n - 1);
        arr[n] = v;
        return v;
    }


    public static void main(String[] args) {
//        System.out.println(fibonacci(10));
        System.out.println(new JzOffer07().fibonacci1(0));
        System.out.println(new JzOffer07().fibonacci1(3));

    }
}
