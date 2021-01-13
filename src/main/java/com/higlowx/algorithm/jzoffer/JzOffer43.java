package com.higlowx.algorithm.jzoffer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * leetcode：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * nowcoder：https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec
 *
 * @author Dylan.Li
 * @date 2021/1/13
 * <p>
 * 以下三种解法的时间、空间复杂度均为O(N)，n是字符串的长度
 */

public class JzOffer43 {


    public String reverseLeftWords(String s, int n) {
        //原生，最快
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            //取余，仅仅是优化了代码结构，复杂度无提升，速度和空间较1稍弱
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JzOffer43 ins = new JzOffer43();
        String s = ins.reverseLeftWords1("abcdefg", 2);
        System.out.println(s);
    }
}
