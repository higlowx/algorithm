package com.higlowx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris.Li
 * @desc
 * @date 2020/4/26
 */

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        int result = 0, index = 0, left = 0;
        while (index < s.length()) {
            Character c = s.charAt(index);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            //此处为什么要使用+1？
            map.put(c, index + 1);
            result = Math.max(result, index - left + 1);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int res0 = new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
        System.out.println(res0);
        int res1 = new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf");
        System.out.println(res1);
        int res2 = new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
        System.out.println(res2);
        int res3 = new LengthOfLongestSubstring().lengthOfLongestSubstring(" ");
        System.out.println(res3);
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


}
