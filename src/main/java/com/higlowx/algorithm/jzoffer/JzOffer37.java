package com.higlowx.algorithm.jzoffer;

/**
 * @author Dylan.Li
 * @date 2020/12/21
 */

public class JzOffer37 {

    /**
     * 解法一：递归二分查找
     * 时间复杂度：O(logN)，二分查找的复杂度
     * 空间复杂度：O(1) + 递归栈占用的内存空间
     */
    public int getNumberOfK(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        //寻找第一个匹配值得下标
        int index = binarySearch(nums, 0, len - 1, target);
        //没找到返回0
        if (index == -1) {
            return count;
        }
        count++;
        //向后查找
        int nextIdx = index;
        while ((nextIdx = nextIdx + 1) <= len - 1
                && nums[nextIdx] == target
                && ++count != 0) {
        }
        //向前查找
        nextIdx = index;
        while ((nextIdx = nextIdx - 1) >= 0
                && nums[nextIdx] == target
                && ++count != 0) {
        }
        return count;
    }

    private int binarySearch(int[] array, int left, int right, int k) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return array[left] == k ? left : -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] > k) {
            //左闭右开
            return binarySearch(array, left, mid, k);
        }
        if (array[mid] < k) {
            return binarySearch(array, mid + 1, right, k);
        }
        return mid;
    }

    /**
     * 解法二：动态规划二分查找
     * 时间复杂度：O(logN)，二分查找的复杂度
     * 空间复杂度：O(1)
     */
    public int getNumberOfK1(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        int left = 0, right = len - 1, mid = 0;
        int firstIdx = -1;
        while (left <= right) {
            if (left == right) {
                firstIdx = nums[left] == target ? left : -1;
                break;
            }
            mid = left + (right - left) / 2;
            if (mid == left && nums[mid] == target) {
                firstIdx = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                firstIdx = mid;
                break;
            }
        }
        //没找到返回0
        if (firstIdx == -1) {
            return count;
        }
        count++;
        //向后查找
        int nextIdx = firstIdx;
        while ((nextIdx = nextIdx + 1) <= len - 1
                && nums[nextIdx] == target
                && ++count != 0) {
        }
        //向前查找
        nextIdx = firstIdx;
        while ((nextIdx = nextIdx - 1) >= 0
                && nums[nextIdx] == target
                && ++count != 0) {
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new JzOffer37().getNumberOfK1(nums, 6));
    }
}
