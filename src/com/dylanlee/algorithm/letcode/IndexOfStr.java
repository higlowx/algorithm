package com.dylanlee.algorithm.letcode;

/**
 * @author Chris.Li
 * @desc
 * @date 2020/5/22
 */

public class IndexOfStr {

    public static void main(String[] args) {
        System.out.println(new IndexOfStr().indexOfStr("adasdasdasd", "as"));
    }

    public int indexOfStr(String sourceStr, String targetStr) {
        char[] strArr = sourceStr.toCharArray();
        char[] target = targetStr.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            int j = 0;
            int max = target.length;
            if (target[j] == strArr[i + j]) {
                while (++j < max && target[j] == strArr[i + j]) ;
            }
            if (j == max) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfStr2(String sourceStr, String targetStr) {
        char[] source = sourceStr.toCharArray();
        char[] target = targetStr.toCharArray();
        char first = target[0];
        int max = source.length - target.length;

        for (int i = 0; i <= max; i++) {
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + target.length - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++) ;

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

}
