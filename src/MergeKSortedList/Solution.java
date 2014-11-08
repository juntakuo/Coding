package MergeKSortedList;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Created by juntakuo on 11/8/14.
 * Question: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
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

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) heap.add(head);
        }

        ListNode head = null;
        ListNode current = null;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
            if (node.next != null) heap.add(node.next);
        }
        return head;
    }

}
