package com.higlowx.algorithm.jzoffer;

import com.alibaba.fastjson.JSON;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author Dylan.Li
 * @date 2020/11/23
 */

public class JzOffer15 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slower = null, faster = head, slowTemp = null, fasterTemp = null;
        while (true) {
            //将中继指针指向快节点的next，以免翻转时导致后续节点丢失
            fasterTemp = faster.next;
            //将快节点的next设为当前慢节点，并将慢节点的next指向上一个慢节点，即完成局部翻转
            faster.next = slower;
            if ((slower = faster.next) != null) {
                slower.next = slowTemp;
            }
            //如果到达最后一个了，直接返回
            if (fasterTemp == null) {
                break;
            }
            //将中继慢指针指向上一个慢节点，以免翻转时前序节点丢失
            slowTemp = slower;
            //将快慢两个指针分别前进一步
            slower = faster;
            faster = fasterTemp;
        }
        return faster;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(JSON.toJSONString(head));
        System.out.println(JSON.toJSONString(new JzOffer15().reverseList(head)));
    }

}
