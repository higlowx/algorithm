package com.higlowx.algorithm.letcode;

/**
 * @author Chris.Li
 * @desc
 * @date 2019/8/30
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[1000000000];
        for (int i = 1; i <= 1000000000; i++) {
            arr[i - 1] = i;
        }
        long a = System.currentTimeMillis();
        System.out.println(new BinarySearch().binarySearch(arr, 100000000));
        long b = System.currentTimeMillis();
        System.out.println(b - a);
        System.out.println(new BinarySearch().lineSearch(arr, 100000000));
        long c = System.currentTimeMillis();
        System.out.println(c - b);

    }

    private int binarySearch(int[] array, int tar) {
        int begin = 0;
        int end = array.length - 1;
        int mid = (begin + end) / 2;
        while (begin <= end) {
            if (array[mid] == tar) {
                return mid;
            }
            if (tar > array[mid]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (begin + end) / 2;
        }
        return -1;
    }

    private int lineSearch(int[] array, int tar) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tar) {
                return i;
            }
        }
        return -1;
    }
}
