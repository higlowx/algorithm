package com.higlowx.algorithm.jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * leetcode：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * nowcoder：https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4
 *
 * @author Dylan.Li
 * @date 2021/2/24
 */

public class JzOffer45 {

    public boolean isStraight(int[] nums) {
        //bad case
        if (nums.length == 0) {
            return false;
        }
        //建立一个set集合用于储存出现过的数字，同时实现非0数字的重复判断
        Set<Integer> collect = new HashSet<Integer>(5);
        //维护min、max变量，用于判定是否超出边界，给定特殊初始值-1，题目中数字的取值是0~13
        int min = -1, max = -1;
        //遍历
        for (int i : nums) {
            //如果数值为0，则不予判定，进入下一次循环
            if (i == 0) {
                continue;
            }
            //未变更min、max初始值，则变更，说人话就是，还没数据呢，加！
            if (min == -1) {
                min = i;
                max = i;
                //别忘了添加进判重集合
                collect.add(i);
                //进入下次循环
                continue;
            }
            //如果已经有数据了
            //首先判断有无重复，只要有>=2个重复的任意数，即不满足5个连续数值的要求，返回false即可
            if (!collect.add(i)) {
                return false;
            }
            //没有重复，就开始区间判断
            //由于min，max两数的存在，一个横向递增且取值在[1,13]的x轴上，会被划分成了多块区间，主要有以下几种情况：
            //[1,min),(min,max),(max,13] ps:注意(min,max)并不是[min,max]，原因是 !collect.add(i) 已经做了去重处理
            //(min=1,max),(max,13]
            //[1,min),(min,max=13)
            //后两种情况是min或者max等于特殊边界时的情况，其依旧满足第一种的假说，比如(min=1,max),(max,13]等价于(1,min=1)(min=1,max),(max,13]
            //对于任意i，一定处于3个区间中的某一个
            //落在[1,min)
            if (i < min) {
                //判断是否超区边界
                if (max - i > 4) {
                    return false;
                }
                min = i;
            } else if (i > max) {//(max,13]
                //判断是否超区边界
                if (i - min > 4) {
                    return false;
                }
                max = i;
            }
            //落在(min,max)，不再处理，因为能到这一步，再判断边界，无非还是判断 max-min > 4，其必定为true
        }
        return true;
    }

    public static void main(String[] args) {
        JzOffer45 ins = new JzOffer45();
        boolean straight = ins.isStraight(new int[]{0, 0, 8, 4, 5});
        System.out.println(straight);
        boolean straight1 = ins.isStraight(new int[]{0, 0, 2, 2, 5});
        System.out.println(straight1);
        boolean straight2 = ins.isStraight(new int[]{1, 6, 5, 4, 2});
        System.out.println(straight2);
    }
}
