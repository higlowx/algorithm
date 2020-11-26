package com.higlowx.algorithm.jzoffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 输入：{8,8,#,9,#,2,#,5},{8,9,#,2}
 * 输出：true
 *
 *
 *
 * leetcode:https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * nowcoder:https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88
 *
 * @author Dylan.Li
 * @date 2020/11/25
 */

public class JzOffer17 {

    /**
     * 分析：
     * 若树B是树A的子结构，则子结构的根节点可能为树A的任意一个节点
     * <p>
     * 算法流程：
     * 名词规定
     * <p>
     * match(A, B) 函数：
     * 终止条件：
     * 当节点B为空：说明树B已匹配完成（越过叶子节点），因此返回 true ；
     * 当节点A为空：说明已经越过树A叶子节点，即匹配失败，返回 false ；
     * 当节点A和B的值不同：说明匹配失败，返回 false ；
     * 返回值：
     * 判断A和B的左子节点是否相等，即 match(A.left, B.left) ；
     * 判断A和B的右子节点是否相等，即 match(A.right, B.right) ；
     * <p>
     * hasSubtree(root1, root2) 函数：
     * <p>
     * 特例处理： 当 树A 为空 或 树B 为空 时，直接返回 false ；
     * 返回值： 若 树B 是 树A 的 子结构，则必满足以下三种情况之一，因此用或 || 连接；
     * 以 节点A 为根节点的子树 包含树B，对应 match(A, B)；
     * 树B 是 树A 左子树 的子结构，对应 hasSubtree(A.left, B)；
     * 树B 是 树A 右子树 的子结构，对应 hasSubtree(A.right, B)；
     * 以上 2. 3. 实质上是在对 树A 做 先序遍历 。
     * <p>
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(MN)O(MN) ： 其中 M,NM,N 分别为树A和 树B的节点数量；先序遍历树A占用 O(M)O(M) ，每次调用 match(A, B) 判断占用 O(N)O(N) 。
     * 空间复杂度 O(M)O(M) ： 当树A和树B都退化为链表时，递归调用深度最大。当 M \leq NM≤N 时，遍历树A与递归判断的总递归深度为 MM ；当 M>NM>N 时，最差情况为遍历至树A叶子节点，此时总递归深度为 MM
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        //从当前节点开始匹配
        return match(root1, root2)
                //从root1的左节点开始匹配
                || hasSubtree(root1.left, root2)
                //从root1的右节点开始匹配
                || hasSubtree(root1.right, root2);
    }

    private boolean match(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return match(a.left, b.left) && match(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.left.left = new TreeNode(2);
        root1.left.left.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.left.left = new TreeNode(2);
        System.out.println(new JzOffer17().hasSubtree(root1, root2));
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
