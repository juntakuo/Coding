package SwapNodesInPairs;

/**
 * Created by juntakuo on 11/16/14.
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = swapPairs(head);
        System.out.println(head.val);
    }

    public static ListNode swapPairs(ListNode head) {
       if (head == null) return null;

        ListNode curr = head, dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            curr = curr.next;

        }
        return dummy.next;
    }
}
