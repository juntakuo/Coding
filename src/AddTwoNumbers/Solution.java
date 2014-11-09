package AddTwoNumbers;

/**
 * Created by juntakuo on 11/8/14.
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        // base case
        if (l1 == null && l2 == null && carry == 0) return null;

        if (l1 != null) carry += l1.val;
        if (l2 != null) carry += l2.val;
        ListNode node = new ListNode(carry % 10);
        node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry / 10);
        return node;
    }

}
