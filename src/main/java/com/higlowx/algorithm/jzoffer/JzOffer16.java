package com.higlowx.algorithm.jzoffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * leetcode:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * nowcoder:https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 *
 * @author Dylan.Li
 * @date 2020/11/24
 */

public class JzOffer16 {


    /**
     * 创建一个头结点，双链表双指针交替比较前进
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
    }


    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
