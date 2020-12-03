package com.higlowx.algorithm.jzoffer;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * leetcode：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * nowcoder：https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba
 *
 * @author Dylan.Li
 * @date 2020/12/3
 */

public class JzOffer25 {

    /**
     * 思路：
     * 第一遍循环完成全部节点的拷贝
     * 第二遍循环完成所有节点的next，random指针维护
     * 借助哈希表的随机访问特性，即可完成
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> oldToCopy = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            oldToCopy.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            oldToCopy.get(cur).next = oldToCopy.get(cur.next);
            oldToCopy.get(cur).random = oldToCopy.get(cur.random);
            cur = cur.next;
        }
        return oldToCopy.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
