package com.higlowx.algorithm.jzoffer;

/**
 * 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。 
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * leetcode：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * nowcoder：https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3
 * nowcoder上该题目要求输入" "返回" "，这样的case，大可不必。。
 *
 * @author Dylan.Li
 * @date 2021/1/14
 */

public class JzOffer44 {

    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        String[] sp = s.split(" ");
        StringBuilder result = new StringBuilder();
        String p;
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!"".equals(p = sp[i])) {
                result.append(p).append(" ");
            }
        }
        //trim去除首尾空格
        return result.toString().trim();
    }

    public static void main(String[] args) {
        JzOffer44 ins = new JzOffer44();
        String s = ins.reverseWords(" hello world! ");
        System.out.println(s);
    }
}
