package com.higlowx.algorithm.jzoffer;

import java.util.LinkedHashMap;

/**
 * @author Dylan.Li
 * @date 2020/12/16
 */

public class JzOffer34 {


    /**
     * 有序哈希表法
     * Q：为什么不使用HashMap，而是使用LinkedHashMap？
     * A：使用LinkedHashMap可以达到插入与遍历的顺序一致
     * <p>
     * Q：为什么第二遍遍历不使用字符串本身，而是使用LinkedHashMap？
     * （对比题解https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/）
     * A：避免了第二次遍历s时因为重复字符导致多余校验的问题
     * <p>
     * <p>
     * 时间复杂度 O(N) ： N 为字符串 s 的长度；LinkedHashMap 查找操作的复杂度为 O(1)
     * 空间复杂度 O(1) ： 由于题目指出 s 只包含小写字母，因此最多有 26 个不同字符，LinkedHashMap 存储需占用 O(26)=O(1) 的额外空间
     */
    public char firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return ' ';
        }
        //初始化大小为26，因为小写英文字母一共26个
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>(26);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                continue;
            }
            //如果已经出现超过两次，则不再重新赋值，减少内存操作
            if (map.get(c) != 0) {
                map.put(c, 0);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) == 0) {
                continue;
            }
            return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new JzOffer34().firstUniqChar("aadadaad"));
    }
}
