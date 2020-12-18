package com.higlowx.algorithm.jzoffer;

/**
 * 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 * <p>
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * leetcode：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * nowcoder：https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
 *
 * @author Dylan.Li
 * @date 2020/12/18
 */

public class JzOffer36 {

    /**
     * 解法一：先分别统计长度，再根据长度是否一致伺机开启同步比对
     * 时间复杂度O(M+N)，M、N分别为两个链表的长度
     * 空间复杂度O(1)
     * 效率极佳
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //统计长度
        int a = 0, b = 0;
        ListNode pointerA = headA;
        while (pointerA != null) {
            a++;
            pointerA = pointerA.next;
        }
        ListNode pointerB = headB;
        while (pointerB != null) {
            b++;
            pointerB = pointerB.next;
        }
        pointerA = headA;
        pointerB = headB;
        //处理长度不一致的情况
        if (a < b) {
            while (a != b && pointerB != null) {
                b--;
                pointerB = pointerB.next;
            }
        } else if (a > b) {
            while (a != b && pointerA != null) {
                a--;
                pointerA = pointerA.next;
            }
        }
        //长度一致后，开启同步意义比对
        while (pointerA != null && pointerB != null) {
            //注意这里不是pointerB.val == pointerA.val，因为val相同，不代表内存地址相同
            if (pointerB == pointerA) {
                return pointerA;
            }
            pointerB = pointerB.next;
            pointerA = pointerA.next;
        }
        return null;
    }

    /**
     * 解法二：双指针交叉遍历
     * 该方法的核心在于：两个指针分别都要走完全部的节点，且在走完的同时正好位于第一个共同节点上
     * 具体解法参照：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
     * <p>
     * 改方法尤其方便于两链表不同长的情况
     * <p>
     * 虽然他们有交点，但他们的长度不一样，所以他们完美的错开了，即使把链表都走完了也找不到相交点。
     * 我们仔细看下上面的图，如果A指针把链表A走完了，然后再从链表B开始走到相遇点就相当于把这两个链表的所有节点都走了一遍，同理如果B指针把链表B走完了，然后再从链表A开始一直走到相遇点也相当于把这两个链表的所有节点都走完了
     * 所以如果A指针走到链表末尾，下一步就让他从链表B开始。同理如果B指针走到链表末尾，下一步就让他从链表A开始。只要这两个链表相交最终肯定会在相交点相遇，如果不相交，最终他们都会同时走到两个链表的末尾
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //tempA和tempB我们可以认为是A,B两个指针
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA = tempA == null ? headB : tempA.next;
            //指针tempB同上
            tempB = tempB == null ? headA : tempB.next;
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //[4,1,8,4,5]
    //[5,0,1,8,4,5]
    public static void main(String[] args) {
//        ListNode headA = new ListNode(4);
//        headA.next = new ListNode(1);
//        headA.next.next = new ListNode(8);
//        headA.next.next.next = new ListNode(4);
//        headA.next.next.next.next = new ListNode(5);
//        ListNode headB = new ListNode(5);
//        headB.next = new ListNode(0);
//        headB.next.next = new ListNode(1);
//        headB.next.next.next = headA.next.next;
//        headB.next.next.next.next = headA.next.next.next;
//        headB.next.next.next.next.next = headA.next.next.next.next;
//        System.out.println(new JzOffer36().getIntersectionNode(headA, headB).val);

        ListNode headC = new ListNode(1);
        ListNode headD = headC;
        System.out.println(new JzOffer36().getIntersectionNode(headC, headD).val);

    }
}
