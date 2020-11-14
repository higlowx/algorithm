package com.higlowx.algorithm.jzoffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author Dylan.Lee
 * @date 2020/11/14
 * @since
 */

public class JzOffer05 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //如果2中已经没有元素了，则一次性将1中所有的元素转移进2
        if (stack2.empty()) {
            while (!stack1.empty()) {
                //如果1内还有元素，则必须依次将其push进2
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        //如果2中还有元素，则优先从2pop
        //Q: 此处为什么还要判断一次2有无元素?
        //A: 是因为极有可能stack1中也没有任何数据可以转移到2中，此时2位空
        return stack2.empty() ? -1 : stack2.pop();
    }

    public static void main(String[] args) {
        JzOffer05 ins = new JzOffer05();
        ins.push(4);
        ins.push(2);
        System.out.println(ins.pop());//4
        ins.push(6);
        System.out.println(ins.pop());//2
        System.out.println(ins.pop());//6
        ins.push(8);
        System.out.println(ins.pop());//8
    }

}
