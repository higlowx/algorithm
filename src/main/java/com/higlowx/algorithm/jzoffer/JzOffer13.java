package com.higlowx.algorithm.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * //TODO 后期在优化，不在此浪费过多时间
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * leetcode:https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * nowcoder:https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593
 *
 * @author Dylan.Li
 * @date 2020/11/21
 */

public class JzOffer13 {


    public void reOrderArray(int[] array) {
        //1
        List<Integer> odd = new ArrayList<Integer>();
        //1
        List<Integer> even = new ArrayList<Integer>();
        //n+1
        for (int i : array) {
            //n
            if (i % 2 == 0) {
                //0~n
                even.add(i);
            } else {
                //0~n
                odd.add(i);
            }
        }
        //1
        odd.addAll(even);
        //n+1
        for (int i = 0; i < array.length; i++) {
            //n
            array[i] = odd.get(i);
        }
    }


    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 3, 5, 7};
        new JzOffer13().reOrderArray(array);
        for (int value : array) {
            System.out.println(value);
        }
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        new JzOffer13().reOrderArray(array2);
        for (int value : array2) {
            System.out.println(value);
        }
    }
}