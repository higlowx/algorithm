package com.higlowx.algorithm.jzoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *
 * @author Dylan.Lee
 * @date 2020/5/26
 * @since
 */
public class JianZhiOffer03 {

    /**
     * 使用java.util.Stack实现
     * 牛客22ms
     * 牛客9224k
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (null == listNode) {
            return new ArrayList<Integer>(0);
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (true) {
            stack.push(listNode.val);
            if (null == listNode.next) {
                break;
            }
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>(stack.size());
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 使用List的add(index，element)方法实现
     * 牛客25ms
     * 牛客9352k
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (null == listNode) {
            return result;
        }
        while (true) {
            result.add(0, listNode.val);
            if (null == listNode.next) {
                break;
            }
            listNode = listNode.next;
        }
        return result;
    }

    /**
     * 递归
     * 牛客22ms
     * 牛客9584k
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode != null) {
            result = printListFromTailToHead3(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        for (int i = 0; i < 1000000; i++) {
            ListNode temp = l1;
            l1 = new ListNode(i);
            l1.next = temp;
        }
        JianZhiOffer03 obj = new JianZhiOffer03();
        //96ms
        long begin1 = System.currentTimeMillis();
        obj.printListFromTailToHead1(l1);
        long end1 = System.currentTimeMillis();
        System.out.println("1耗时:" + (end1 - begin1) + "ms");
        //59071ms
        long begin2 = System.currentTimeMillis();
        obj.printListFromTailToHead2(l1);
        long end2 = System.currentTimeMillis();
        System.out.println("2耗时:" + (end2 - begin2) + "ms");
        //StackOverFlow！！！！
        long begin3 = System.currentTimeMillis();
        System.out.println(obj.printListFromTailToHead3(l1));
        long end3 = System.currentTimeMillis();
        System.out.println("3耗时:" + (end3 - begin3) + "ms");
    }

}
