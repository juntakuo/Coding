package ReverseNodesInKGroup;

/**
 * Created by juntakuo on 11/16/14.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 * }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k < 0) return head;


        /*
         1. -1     -> 1     -> 2 -> 3 -> 4 -> 5
            dummy,  start          end
            prev
         2. -1     -> 2  -> 3 ->   1   -> 4 -> 5
           dummy,          end   start
           prev
         3. -1     -> 3 -> 2 -> 1 -> 4 -> 5
           dummy,    end      start
           prev
         */

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while (curr != null) {
            ListNode start = curr, end = curr;
            int count = k;
            while (end != null && --count > 0) end = end.next;
            if (end != null) {
                while (curr != end) {
                    prev.next = curr.next;
                    curr.next = end.next;
                    end.next = curr;
                    curr = prev.next;
                }
                prev = start;
                curr = start.next;
            } else break;
        }
        return dummy.next;

    }
}
