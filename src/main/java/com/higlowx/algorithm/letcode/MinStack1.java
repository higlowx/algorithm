package com.higlowx.algorithm.letcode;

import java.util.Stack;

/**
 * @author Chris.Li
 * @desc 辅助栈
 * @date 2020/5/14
 */

public class MinStack1 {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack1() {
        stack = new Stack<Integer>();;
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
            return;
        }
        if (x <= minStack.peek()) {
            minStack.push(x);
        }

    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.empty() ? 0 : stack.peek();
    }

    public int getMin() {
        return minStack.empty() ? 0 : minStack.peek();
    }
}
