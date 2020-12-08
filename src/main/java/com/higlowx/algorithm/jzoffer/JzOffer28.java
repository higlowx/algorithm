package main.java.com.higlowx.algorithm.jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 50000
 * <p>
 * leetcode：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * nowcoder：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 *
 * @author Dylan.Lee
 * @date 2020/12/8
 */

public class JzOffer28 {

    /**
     * 解法一，利用hashtable实现
     * 时间、空间复杂度均为O(N)
     */
    HashMap<Integer, Integer> count = null;

    public int majorityElement0(int[] nums) {
        if (count == null) {
            count = new HashMap<>(nums.length / 2);
        }
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.put(num, 0);
            }
            int c = count.get(num) + 1;
            if (c > nums.length / 2) {
                return num;
            }
            count.put(num, c);
        }
        throw new RuntimeException();
    }


    /**
     * 解法二，先排序，再取中间点的数，其一定是众数，即此题中出现次数超过数组大小一半的数
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public int majorityElement1(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        return list.get(list.size() / 2);
    }

    /**
     * 解法三，摩尔投票法（最优解）
     * <p>
     * 推论一： 若记 众数 的票数为 +1，非众数 的票数为 −1，则一定有所有数字的 票数和 >0。
     * 推论二： 若数组的前 a 个数字的 票数和 = 0，则 数组剩余 (n-a) 个数字的 票数和一定仍 >0，即后 (n-a) 个数字的 众数仍为 x。
     * <p>
     * 改解法的核心思路是：依次遍历数组，假设当前index上数值x为众数，则票数+1，
     * 继续向后遍历，如果后边的数 == x，则 总票数 +1；如果后边的数 != x，则总票数 -1；
     * 监听 总票数 在 整个遍历过程中的 值变化，中间阶段一旦变为 0，则需要 重新指定 新的 假设众数x，并继续向后遍历
     * <p>
     * 时间复杂度O(N)；空间复杂度O(1)：votes变量使用常数大小的额外空间
     * <p>
     * 详细思路见：
     * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     */
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        //此处需要兼容异常输入，例如{1,2,3,2,5,2,2,6,3},共9个元素，出现次数最多的是2，但是只出现了4次，不满足超过长度一半的限制
        //源自nowcoder未通过的测试用例
        int count = 0;
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0;
    }

}
