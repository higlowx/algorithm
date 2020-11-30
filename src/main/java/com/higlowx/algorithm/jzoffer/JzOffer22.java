package com.higlowx.algorithm.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7]
 *       3
 *      / \
 *     9  20
 *   /  \
 * 15   7
 * 返回：
 * [3,9,20,15,7]
 *  
 * 提示：
 * 节点总数 <= 1000
 * <p>
 * leetcode:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * nowcoder:https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701
 *
 * @author Dylan.Li
 * @date 2020/11/30
 */

public class JzOffer22 {


    /**
     * 分析：
     * 考察二叉树的层级遍历，其实现为 广度优先搜索（BFS，Breadth First Search）
     * 补充扩展：最短路径算法是BFS算法的一种扩展，其使用的队列通常意义上是 优先队列，这种队列可以实现 内部元素 按照 加权的大小 顺序调整队列内的元素顺序
     * 需要依赖 队列 这种数据结构来实现
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> container = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            container.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[container.size()];
        for (int i = 0; i < container.size(); i++) {
            res[i] = container.get(i);
        }
        return res;
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
