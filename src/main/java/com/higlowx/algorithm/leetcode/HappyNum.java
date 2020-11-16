package com.higlowx.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chris.Li
 * @desc
 * @date 2020/4/30
 */

public class HappyNum {

    //解题的关键点有两个：
    //1.计算平方和
    //2.避免死循环->如果出现过重复平方和且这个平方和不等于1，即视为死循环且永远不会满足快乐数的定义，此时返回false
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<Integer>();
        while (n != 1) {
            if (!sumSet.add(n)) {
                return false;
            }
            n = squareSum(n);
        }
        return true;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNum().isHappy(19));
    }
}
