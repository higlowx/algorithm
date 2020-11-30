package com.higlowx.algorithm.jzoffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * leetcode:https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * nowcoder:https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106
 *
 * @author Dylan.Li
 * @date 2020/11/30
 */

public class JzOffer21 {


    /**
     * 错误解法1
     * 错误：无法终止循环
     * 原因：比较栈顶元素与popped[j]是否相等，有两个先决条件
     * A、每次push之后
     * B、如果比较结果为 相等，则应该继续 连续比较，直至第一次 不等时结束，然后在进入下一次push
     * <p>
     * 该解法的错误之处在于，条件B没有满足连续比较，导致，每次push之后，如果栈顶元素与popped[j]相等，只pop一次，然后立刻进入下一次push，
     * 这就导致while循环中的(!stack.empty() && stack.peek().equals(popped[j]))条件始终无法满足，进一步造成始终j<popped.len，所以循环无法终止
     */
    public boolean validateStackSequences0(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        while (true) {
            if (i < pushed.length) {
                stack.push(pushed[i]);
                i++;
            }
            if (!stack.empty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
            if (j >= popped.length) {
                break;
            }
        }
        return stack.empty();
    }

    /**
     * 该方法是上方错误解法1的修复版
     **/
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            stack.push(pushed[i]);
            i++;
            while (!stack.empty() && j < popped.length && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    /**
     * 改进版
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int value : pushed) {
            stack.push(value);
            while (!stack.empty() && j < popped.length && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 3, 5, 1, 2};
        System.out.println(new JzOffer21().validateStackSequences1(a, b));
    }
}
