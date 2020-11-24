package com.higlowx.algorithm.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * @author Dylan.Li
 * @date 2020/11/23
 */

public class JzOffer14 {


    /**
     * 暴力解法，借助List，空间占用需要优化
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        if (head == null) {
            return null;
        }
        list.add(head);
        while (head.next != null) {
            list.add(head.next);
            head = head.next;
        }
        return list.size() - k < 0 ? null : list.get(list.size() - k);
        //1 2 3 4
        //k = 2
        //4 3
        //return 3
        //size = 4
        //indexOf 3 = 2 = 4-2;
    }

    /**
     * 快慢指针
     * 解法详解：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/
     * 该解法时间占用和空间占用上都非常优秀
     */
    public ListNode findKthToTail1(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode fasterNode = head, slowerNode = head;
        int fasterCount = 1;
        while (true) {
            if (fasterCount > k) {
                slowerNode = slowerNode.next;
            }
            fasterNode = fasterNode.next;
            fasterCount++;
            if (fasterNode == null) {
                //当快指针指向节点变为空时，即fasterCount=链表的容量+1时，反推出链表容量为fasterCount-1，
                //判断链表的容量是不是大于等于k，如果不满足，则k不合法,返回null
                return fasterCount - 1 < k ? null : slowerNode;
            }
        }
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
