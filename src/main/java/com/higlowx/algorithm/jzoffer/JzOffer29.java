package com.higlowx.algorithm.jzoffer;

/**
 *输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * leetcode：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * nowcoder：https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 *
 * @author Dylan.Li
 * @date 2020/12/9
 */

public class JzOffer29 {

    /**
     * 暴力使用快排-挖坑法
     *
     * 平均时间复杂度是O(nlogn)，最坏是O(n^2)，
     * 空间复杂度是期望为 O(logn)，递归调用的期望深度为O(logn)，每层需要的空间为O(1)，只有常数个变量，最坏是O(n)
     *
     * 另外还有一种快排的衍生解法，时间复杂度可以优化至o(n)，详情请见以下链接解法三：
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        if (k > 0) {
            System.arraycopy(arr, 0, res, 0, k);
        }
        return res;
    }

    private void quickSort(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }
        int low = beginIndex;
        int high = endIndex;
        int key = arr[low];
        while (low < high) {
            while (arr[high] >= key && high > low) {
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= key && low < high) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        quickSort(arr, low + 1, endIndex);
        quickSort(arr, beginIndex, low - 1);
    }
}
