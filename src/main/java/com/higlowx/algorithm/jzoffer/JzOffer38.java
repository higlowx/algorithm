package com.higlowx.algorithm.jzoffer;

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
 * leetcode：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * nowcoder：https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b
 *
 * @author Dylan.Li
 * @date 2020/12/22
 */

public class JzOffer38 {


    /**
     * 解法一：递归
     * 时间复杂度:O(N)，每个节点都要递归一次，递归N次，每次递归的时间复杂度是O(1)，所以最终为O(N)
     * 空间复杂度:递归栈空间
     */
    public int treeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        JzOffer38 ins = new JzOffer38();
        int depth = ins.treeDepth(root);
        System.out.println(depth);
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
