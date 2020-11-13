package com.higlowx.algorithm.jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * TODO
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author Dylan.Lee
 * @date 2020/5/26
 * @since
 */

public class JzOffer04 {

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 首次循环至此，得到中序数组中根节点的index=3，以index=3为界限，左右将中序数组拆分为 左子树中序数组 和 右子树中序数组
                // 以左子树中序数组为例，其中的元素可以非常直观的看到，即{4,7,2}，元素数为3（(index=3)-0=3）
                // 以元素数3为依据，从前序数组根节点index=0，向后增加3个位置，得到index=3的位置
                // 前序根节点index=0到index=3的位置之间的中间数组{2,4,7}，正是上边左子树中序数组{4,7,2}的前序数组
                // 将拆分出的 左子树中序数组、左子树前序数组 作为入参进行递归调用，即可得到最终的左子树，右子树同理

                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                //找到根后及时终止循环，不用再向下找了，这就是题目说明中“假设输入的前序遍历和中序遍历的结果中都不含重复的数字”的意图所在
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);

        System.out.println(JSON.toJSONString(treeNode));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getRight() {
        return right;
    }
}
