package com.higlowx.algorithm.letcode;

import java.util.Arrays;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * 示例：
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 * numbers.length == 2
 * <p>
 * https://leetcode-cn.com/problems/swap-numbers-lcci
 * <p>
 * 思路：{3,2}->{5,2}->{5,3}->{2,3}
 *
 * @author Dylan.Lee
 * @date 2020/6/2
 * @since
 */

public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public int[] swapNumbers1(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        int[] res = new SwapNumbers().swapNumbers1(new int[]{3, 2});
        System.out.println(Arrays.toString(res));
    }
}
