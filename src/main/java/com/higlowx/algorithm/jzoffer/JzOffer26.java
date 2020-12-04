package com.higlowx.algorithm.jzoffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *

 * leetcode：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * nowcoder：https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
 *
 * @author Dylan.Li
 * @date 2020/12/4
 */

public class JzOffer26 {

    private Node head = null;
    private Node lastNode = null;

    //
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        cur(root);
        //如果总共只有一个节点
        if (head.val == lastNode.val) {
            return root;
        }
        head.left = lastNode;
        lastNode.right = head;
        return head;
    }

    private void cur(Node cur) {
        if (cur == null) {
            return;
        }
        cur(cur.left);
        if (lastNode == null) {
            head = cur;
            lastNode = cur;
        } else {
            lastNode.right = cur;
        }
        cur.left = lastNode;
        lastNode = cur;
        cur(cur.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ;
}
