/**
 * @author Chris.Li
 * @desc
 * @date 2020/4/24
 */

public class AddTwoNums {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        do {
            int sum = carry + (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0);
            int take = sum % 10;
            pointer.next = new ListNode(take);
            carry = sum / 10;
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
            pointer = pointer.next;
        } while (null != p1 || p2 != null);
        pointer.next = carry != 0 ? new ListNode(carry) : null;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode result = new AddTwoNums().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

