package com.higlowx.algorithm.jzoffer;

/**
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * leetcode:https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * nowcoder:https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 *
 * @author Dylan.Li
 * @date 2020/11/28
 */

public class JzOffer20 {


    private StackNode node = null;
    private StackNode minNode = null;

    public JzOffer20() {

    }

    public void push(int x) {
        //初始化一个新的node节点
        StackNode pushNode = new StackNode(x);
        //如果当前对象的头节点node不为空，则将新插入的节点的next指向已有头node
        if (null != this.node) {
            pushNode.next = this.node;
        }
        //将头node更改为新插入节点
        this.node = pushNode;
        //开始最小栈的维护
        //如果最小栈的头node为空，则直接将最小栈的头结点就是当前node，不需要比较
        if (null == minNode) {
            this.minNode = pushNode;
            return;
        }
        //如果已经有最小栈的链表
        //如果新插入节点的值小于等于当前最小栈的头node的值，则将当前节点指定为新的最小栈头节点，同时维护新的最小栈前后关系指针
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

    public int min() {
        return null == this.minNode ? 0 : this.minNode.value;
    }

    private static class StackNode {
        Integer value;
        StackNode next = null;
        StackNode min = null;

        StackNode(int x) {
            value = x;
        }
    }

}
