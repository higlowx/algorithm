package com.higlowx.algorithm.jzoffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * leetcode：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * nowcoder：
 *
 * @author Dylan.Li
 * @date 2020/12/1
 */

public class JzOffer23 {

    /**
     * 同思想题解：
     * A：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     * B：https://www.bilibili.com/video/BV1X7411q7Bw
     *
     * 复杂度分析：
     * 时间复杂度 O(N^2)：每次调用 subVerify() 减去一个根节点，因此递归会执行N次，最差情况下（即当树退化为链表），
     * 每轮递归都需遍历树所有节点，遍历N次，所以是O(N^2)。
     *
     * 空间复杂度 O(N)：最差情况下（即当树退化为链表），递归深度将达到 N。
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return subVerify(postorder, 0, postorder.length - 1);
    }

    private boolean subVerify(int[] postorder, int subL, int subR) {
        if (subR - subL < 1) {
            return true;
        }
        int less = subL;
        while (postorder[less] < postorder[subR]) {
            less++;
        }
        int more = less;
        while (postorder[more] > postorder[subR]) {
            more++;
        }
        return more == subR && subVerify(postorder, subL, less - 1) && subVerify(postorder, less, subR - 1);
    }

    public static void main(String[] args) {
        int[] nodes = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(new JzOffer23().verifyPostorder(nodes));
    }
}
