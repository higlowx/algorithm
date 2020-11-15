package com.higlowx.algorithm.jzoffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * @author Dylan.Lee
 * @date 2020/11/15
 * @since
 */

public class JzOffer06 {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int first = 0;
        int last = array.length - 1;
        int mid = 0;
        int min = 0;
        //因为已知该数组是非递减数组，所以再数组旋转之前，该数组中任意相邻两个元素之间的关系一定是：前一个元素小于等于后一个元素
        //由于目标数组已经旋转，导致前边一部分元素整体挪到了末尾，所以：目前一定存在前一个元素大于等于相邻的后一个元素
        //以此为根据开始变种的二分查找法，由于事先没有给定目标值target，这里我们直接使用右端点作为target
        while (true) {
            //控制退出
            if (first >= last) {
                return array[min];
            }
            mid = (first + last) / 2;

            if (array[mid] > array[last]) {
                //情况1，array[mid] > array[last]：4 5 6 1 2 3
                //array[mid] 为 6， array[last] 为 3，
                //array[mid] > target, 说明[first ... mid] 都是 >= target 的，
                //因为原始数组是非递减，所以可以确定答案为 [mid+1...last]区间,所以 first = mid + 1
                first = mid + 1;
                min = last;
            } else if (array[mid] < array[last]) {
                //情况2，array[mid] < array[last]:5 6 1 2 3 4
                //array[mid] 为 1， array[last] 为 4，
                //array[mid] < target, 说明答案肯定不在[mid+1...last]，但是array[mid]有可能是答案,所以答案在[first, mid]区间，所以last = mid;
                last = mid;
                min = mid;
            } else {
                //情况3，array[mid] == array[last]:
                //如果是 1 0 1 1 1， array[mid] = target = 1, 显然答案在左边
                //如果是 1 1 1 0 1, array[mid] = target = 1, 显然答案在右边
                //所以这种情况，不能确定答案在左边还是右边，那么就让last = last - 1;慢慢缩少区间，同时也不会错过答案。
                min = last;
                last--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3};
        int i = new JzOffer06().minNumberInRotateArray(arr);
        System.out.println(i);
    }
}
