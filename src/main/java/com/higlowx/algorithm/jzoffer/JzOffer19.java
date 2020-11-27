package com.higlowx.algorithm.jzoffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * leetcode:https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * nowcoder:https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a
 *
 * @author Dylan.Li
 * @date 2020/11/27
 */

public class JzOffer19 {


    /**
     * l   r
     * 1 2 3 u
     * 4 5 6
     * 7 8 9
     * 3 5 7 d
     * <p>
     * 我们需要维护left、right、up、down这4个基础坐标值，他们两两组合可以得到上下左右四个顶点的位置，
     * 将四个顶点相连，这样就串出了每一次顺时针之后所有遍历到的节点
     * 接下来只需要重复这个过程，并维护l、r、u、d，直到l=r=u=d即可结束整个遍历过程
     * 同时，对于结束条件来说，还有另外一个维度去切入思考，就是最终结果数组res的长度
     * 理论上，其长度len应该为matrix的row*col，当res的赋值指针idx超过len，即可结束整个过程
     * <p>
     * 下面我们用简单的描述，梳理一下每一次顺时针的过程
     * l→ | l==r时，direction↓ | u++
     * u↓ | u==d时，direction← | r--
     * r← | r==l时，direction↑ | d--
     * d↑ | d==u时，结束一次顺时针循环 | l++
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, up = 0, down = row - 1;
        int[] res = new int[row * col];
        int idx = 0;
        while (idx < res.length) {
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[up][i];
                if (idx >= res.length) {
                    return res;
                }
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[idx++] = matrix[i][right];
                if (idx >= res.length) {
                    return res;
                }
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[down][i];
                if (idx >= res.length) {
                    return res;
                }
            }
            down--;
            for (int i = down; i >= up; i--) {
                res[idx++] = matrix[i][left];
                if (idx >= res.length) {
                    return res;
                }
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(matrix[0][0]);//1
        System.out.println(matrix[1][0]);//4
        System.out.println(matrix[0][1]);//2
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

    }


}
