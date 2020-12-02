package com.higlowx.algorithm.jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *  
 * 提示：
 * 节点总数 <= 10000
 * <p>
 * leetcode：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * nowcoder：https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 *
 * @author Dylan.Li
 * @date 2020/12/2
 */

public class JzOffer24 {


    /**
     * 详细解题过程与错题记录请见main方法
     */

    public List<List<Integer>> pathSum0(TreeNode root, int sum) {
        return curPath0(root, sum, new ArrayList<Integer>());
    }

    private List<List<Integer>> curPath0(TreeNode node, int difference, List<Integer> cur) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (node == null) {
            return res;
        }
        if (node.val < difference) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            List<List<Integer>> leftLists = curPath0(node.left, difference - node.val, path);
            List<List<Integer>> rightLists = curPath0(node.right, difference - node.val, path);
            res.addAll(leftLists);
            res.addAll(rightLists);
        } else if (node.val == difference) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            res.add(path);
        }
        return res;
    }

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        return curPath1(root, sum, new ArrayList<Integer>());
    }

    private List<List<Integer>> curPath1(TreeNode node, int difference, List<Integer> cur) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (node == null) {
            return res;
        }
        if (node.val < difference) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            List<List<Integer>> leftLists = curPath1(node.left, difference - node.val, path);
            List<List<Integer>> rightLists = curPath1(node.right, difference - node.val, path);
            res.addAll(leftLists);
            res.addAll(rightLists);
        } else if (node.val == difference && node.left == null && node.right == null) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            res.add(path);
        }
        return res;
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        return curPath2(root, sum, new ArrayList<Integer>());
    }

    private List<List<Integer>> curPath2(TreeNode node, int difference, List<Integer> cur) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (node == null) {
            return res;
        }
        if (difference - node.val != 0) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            List<List<Integer>> leftLists = curPath2(node.left, difference - node.val, path);
            List<List<Integer>> rightLists = curPath2(node.right, difference - node.val, path);
            res.addAll(leftLists);
            res.addAll(rightLists);
        } else if (node.left == null && node.right == null) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            res.add(path);
        }
        return res;
    }

    /**
     * 正确解法，暴力递归
     */
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        return curPath3(root, sum, new ArrayList<Integer>());
    }

    private List<List<Integer>> curPath3(TreeNode node, int difference, List<Integer> cur) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (node == null) {
            return res;
        }
        if (difference - node.val != 0 || node.left != null || node.right != null) {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            List<List<Integer>> leftLists = curPath3(node.left, difference - node.val, path);
            List<List<Integer>> rightLists = curPath3(node.right, difference - node.val, path);
            res.addAll(leftLists);
            res.addAll(rightLists);
        } else {
            List<Integer> path = new ArrayList<Integer>(cur);
            path.add(node.val);
            res.add(path);
        }
        return res;
    }


    /**
     * leetcode解法：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
     */
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> pathSum5(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null){
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<Integer>(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }

    public static void main(String[] args) {
        //输入[1,2],1输出[[1]]，leetcode报错，其预期是[]，原因出在我们将提议理解为了子节点，而不是叶子结点
        //很显然，leetcode说的叶节点就是叶子结点，也就是说，所有路径必须要到达叶子结点才可以,我们在解法1中做出修正
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        List<List<Integer>> lists = new JzOffer24().pathSum0(root, 1);
        System.out.println(JSON.toJSONString(lists));
        List<List<Integer>> lists1 = new JzOffer24().pathSum1(root, 1);
        System.out.println(JSON.toJSONString(lists1));
        //输入[-2,null,-3],-5输出[]，leetcode报错，其预期是[[-2,-3]]，原因出在对负值的比较不兼容，需要修改解法1中78行与85行的判断条件，我们再解法2中做出修正
        TreeNode root1 = new TreeNode(-2);
        root1.right = new TreeNode(-3);
        List<List<Integer>> lists2 = new JzOffer24().pathSum1(root1, -5);
        System.out.println(JSON.toJSONString(lists2));
        List<List<Integer>> lists3 = new JzOffer24().pathSum2(root1, -5);
        System.out.println(JSON.toJSONString(lists3));
        //输入[1,-2,-3,1,3,-2,null,-1],-1输出[]，leetcode报错，其预期为[[1,-2,1,-1]]
        //错误出在解法2第109行处，当寻路轨迹为根、左时，即为1，-2时，已经满足了sum=-1了，这时候当前节点(左，val=-2)依旧还有左右子节点，但是不会再往后走了
        //所以无法出现leetcode期望的[1,-2,1,-1]的结果，我们将在解法3中予以修正
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(-2);
        root2.right = new TreeNode(-3);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(-2);
        root2.left.left.left = new TreeNode(-1);
        List<List<Integer>> lists4 = new JzOffer24().pathSum2(root2, -1);
        System.out.println(JSON.toJSONString(lists4));
        List<List<Integer>> lists5 = new JzOffer24().pathSum3(root2, -1);
        System.out.println(JSON.toJSONString(lists5));

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
