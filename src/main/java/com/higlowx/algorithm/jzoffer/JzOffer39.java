package com.higlowx.algorithm.jzoffer;

/**
 * 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 限制：
 * 1 <= 树的结点个数 <= 10000
 *
 * leetcode：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * nowcoder：https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
 *
 * @author Dylan.Li
 * @date 2020/12/23
 */

public class JzOffer39 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return depth(root) != -1;
    }

    /**
     * 改进自38题
     * 由底向顶 递归计算每个子树的左右深度，如果出现不平衡的情况，直接向上层递归返回-1
     *
     * 时间复杂度:O(N)，每个节点都要递归一次，递归N次，每次递归的时间复杂度是O(1)，所以最终为O(N)
     * 空间复杂度:递归栈空间
     */
    private int depth(TreeNode tree){
        if(tree == null){
            return 0;
        }
        int leftDepth = depth(tree.left);
        int rightDepth = depth(tree.right);
        //捕获内层递归的不平衡情况，并继续向外层递归抛出
        if(leftDepth == -1 || rightDepth == -1){
            return -1;
        }
        //计算左右子树深度的差值，大于1，则不平衡，返回-1
        if(Math.abs(rightDepth - leftDepth) > 1){
            return -1;
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
