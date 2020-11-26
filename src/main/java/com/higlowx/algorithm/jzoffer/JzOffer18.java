package com.higlowx.algorithm.jzoffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 即交换每个节点的左右子节点
 * <p>
 * leetcode:https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * nowcoder:https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 *
 * @author Dylan.Li
 * @date 2020/11/26
 */

public class JzOffer18 {


    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = right;
            mirror(root.right);
            mirror(root.left);
        }
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
