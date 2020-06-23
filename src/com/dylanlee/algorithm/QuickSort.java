package com.dylanlee.algorithm;

import java.util.Arrays;

/**
 * @author Chris.Li
 * @desc
 * @date 2019/9/19
 */

public class QuickSort {

    //挖坑法
    //1.选取一个关键字(key)作为枢轴，一般取整组记录的第一个数/最后一个，这里采用选取序列最后一个数为枢轴，也是初始的坑位。
    //2.设置两个变量low = 0;high = N - 1;
    //3.从low一直向后走，直到找到一个大于key的值，然后将该数放入坑中，坑位变成了array[low]。
    //4.high一直向前走，直到找到一个小于key的值，然后将该数放入坑中，坑位变成了array[high]。
    //5.重复3和4的步骤，直到left和right相遇，然后将key放入最后一个坑位。
    private static void quickSort1(int[] array, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }
        int low = beginIndex;
        int high = endIndex;
        int key = array[low];
        while (low < high) {
            while (array[high] >= key && high > low) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= key && low < high) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        System.out.println("low: " + low);
        System.out.println("high: " + high);
        quickSort1(array, low + 1, endIndex);
        quickSort1(array, beginIndex, low - 1);
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{5, 4, 6, 1, 9, 7, 3, 3, 3, 3, 10, 8, 5, 2};
        quickSort1(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = new int[]{5, 4, 6, 1, 9, 7, 3, 3, 3, 3, 10, 8, 5, 2, 6, 5, 8, 3, 1, 1, 2, 0, 0, 4,54,33,5,22,87,98,36,0,45,7654,4};
        quickSort2(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }

    //前后指针
    //选取一个关键字(key)作为枢轴，一般取整组记录的第一个数/最后一个，这里采用选取序列最后一个数为枢轴。
    //设置两个变量frontPointer = 0;rearPointer = N - 1;
    //从frontPointer一直向后走，直到找到一个大于key的值，rearPointer从后至前，直至找到一个小于key的值，然后交换这两个数。
    //重复第三步，一直往后找，直到frontPointer和rearPointer相遇，这时将key放置frontPointer的位置即可。
    private static void quickSort2(int[] array, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }
        int frontPointer = beginIndex;
        int rearPointer = endIndex;
        int key = array[frontPointer];
        while (frontPointer != rearPointer) {
            while (array[rearPointer] >= key && rearPointer > frontPointer) {
                rearPointer--;
            }
            while (array[frontPointer] <= key && rearPointer > frontPointer) {
                frontPointer++;
            }
            if (frontPointer < rearPointer) {
                int temp = array[frontPointer];
                array[frontPointer] = array[rearPointer];
                array[rearPointer] = temp;
            }
        }
        array[beginIndex] = array[rearPointer];
        array[rearPointer] = key;
        quickSort2(array, beginIndex, frontPointer - 1);
        quickSort2(array, frontPointer + 1, endIndex);
    }
}
