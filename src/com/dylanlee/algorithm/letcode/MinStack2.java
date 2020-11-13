package com.dylanlee.algorithm.letcode;

/**
 * @author Chris.Li
 * @desc 链表
 * @date 2020/5/13
 */

public class MinStack2 {

    private StackNode node = null;
    private StackNode minNode = null;

    public MinStack2() {

    }

    public void push(int x) {
        StackNode pushNode = new StackNode(x);
        if (null != this.node) {
            pushNode.next = this.node;
        }
        this.node = pushNode;
        if (null == minNode) {
            this.minNode = pushNode;
            return;
        }
        if (pushNode.value <= this.minNode.value) {
            pushNode.min = this.minNode;
            this.minNode = pushNode;
        }

    }

    public void pop() {
        if (null == this.node) {
            return;
        }
        if (this.node == this.minNode) {
            this.minNode = this.minNode.min;
        }
        this.node = this.node.next;
    }

    public int top() {
        return null == this.node ? 0 : this.node.value;
    }

    public int getMin() {
        return null == this.minNode ? 0 : this.minNode.value;
    }


    public static void main(String[] args) {
        MinStack2 stack = new MinStack2();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }
}

class StackNode {
    Integer value;
    StackNode next = null;
    StackNode min = null;

    StackNode(int x) {
        value = x;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */



