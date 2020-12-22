package com.higlowx.algorithm.jzoffer;

import java.util.Stack;

/**
 * 二叉树的深度
 * <p>
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 提示：
 * 节点总数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * leetcode：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * nowcoder：https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b
 *
 * @author Dylan.Li
 * @date 2020/12/22
 */

public class JzOffer38 {


    /**
     * 解法一：深度优先搜索（DFS）
     * <p>
     * 参考 二叉树的层级遍历 中使用BFS并引入 辅助队列 的方式
     * 这里，我们将使用 辅助栈 这种数据结构 来实现
     * 栈的特性是 后进先出
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int tempDepth = 1;
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            //当栈顶元素是root时，表明前一次深度优先搜索已经结束
            //这是需要计算得出目前的最大深度，并存储至depth中，tempDepth重新置为1
            if (peek == root) {
                depth = tempDepth > depth ? tempDepth : depth;
                tempDepth = 1;
            }
            tempDepth += 1;
            if (peek.left != null) {
                stack.push(peek.left);
            }
            if (peek.right != null) {
                stack.push(peek.right);
            }
        }
        return 0;
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
