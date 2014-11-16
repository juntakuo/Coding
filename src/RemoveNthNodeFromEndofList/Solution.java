package RemoveNthNodeFromEndofList;

/**
 * Created by juntakuo on 11/15/14.
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n < 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = head;
        while (tail != null && n > 0) {
            tail = tail.next;
            --n;
        }
        if (n > 0 && tail == null) return head;
        else if (n == 0 && tail == null) {
            return dummy.next.next;
        }

        while (tail != null) {
            prev = prev.next;
            tail = tail.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
