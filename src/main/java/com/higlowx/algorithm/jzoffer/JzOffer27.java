package main.java.com.higlowx.algorithm.jzoffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 * <p>
 * leetcode：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * nowcoder：
 *
 * @author Dylan.Li
 * @date 2020/12/7
 */

public class JzOffer27 {


    /**
     * 回溯算法：
     * 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，
     * 当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
     * 回溯法是一种 选优搜索法，按选优条件向前搜索，以达到目标。
     * 但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
     *
     * @see 这种走不通就退回再走的技术为回溯法,而满足回溯条件的某个状态的点称为
     * @see 回溯点
     * <p>
     * @see 另外,其思想与深度优先搜索算法DFS中的剪枝概念相似
     * <p>
     * 此题的核心思路在于：逐个遍历搜索时，排除同一个位置中有相同字符的其他分支
     * 这个排除的实现，我们可以使用 set实现
     * 同时，为了达到逐个搜索病拼接的效果，我们需要实现一个可以递归调用的函数
     * <p>
     * 该题的详细思路可以参考：
     * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
     */

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        //如果指针到达字符串s的末尾，则代表DFS触底，可以结束本路径
        if (x == c.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        //开启一个set集合，用于判断i这个位置上是否已经存在过当前的字符
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // 重复，则剪枝，进入下一次循环
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i, x);
        }
    }

    /**
     * Q:为什么将字符 c[i]和 c[x] 交换，即固定 c[i] 为当前位字符
     * A:建议如果想不通的话可以只想“固定第一个字符”。
     * 你想，第一个字符有 a b c 三种情况， 分别对应： a 和 a交换， a 和 b 交换， a 和 c 交换~
     */
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
