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
     * <p>
     * 时间复杂度：
     * n=0|1|2 => O(1)
     * n>2 => O(2^n) 非多项式复杂度量级，随着n的增大，效率成指数级降低
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
     * 2、递归+数组，数组其实就是缓存计算过的值，避免重复计算，有些动态规划的思想在其中
     * 执行速度从519ms升级为10ms，执行速度50倍与方法1
     * 缺点：空间复杂度为O(n)+递归所耗用的栈空间
     */
    int[] arr;

    public int fibonacci1(int n) {
        if (arr == null) {
            arr = new int[n + 1];
        }
        int v;
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

    /**
     * 3、动态规划
     * 这里我们不再使用方法2中的递归，将空间复杂度降至O(n)
     * Q: 如何做到不使用递归呢
     * A: 将有n到0的倒序计算过程改为正序一次计算并缓存，用循环替代递归
     */
    public int fibonacci2(int n) {
        int[] arr = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 4、动态规划+持续优化
     * 通过方法3，我们可以看到，其实真正参与每次计算的只有三个节点，能不能一直使用这三个呢，如果可以的话，空间时间复杂度直接升级到O(1)
     */
    public int fibonacci3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = b + a;
            a = b;
            b = c;
        }
        return c;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new JzOffer07().fibonacci0(39));
        long end = System.currentTimeMillis();
        System.out.println("递归：" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        System.out.println(new JzOffer07().fibonacci1(39));
        end = System.currentTimeMillis();
        System.out.println("递归+数组缓存：" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        System.out.println(new JzOffer07().fibonacci2(39));
        end = System.currentTimeMillis();
        System.out.println("动态规划：" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        System.out.println(new JzOffer07().fibonacci3(39));
        end = System.currentTimeMillis();
        System.out.println("动态规划+空间优化：" + (end - start) + "毫秒");
    }
}
