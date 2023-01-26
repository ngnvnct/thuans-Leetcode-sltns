package linked_list;

import java.util.PriorityQueue;

public class problem_0023_merge_k_sorted_lists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.value);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }
        return dummy.next;
    }
}

/*
 * abstract
 * Explanation
 * Using a min heap, we add the smallest value to the heap
 * then we pop it out and form a new list
 * 
 * Time: O(nlogk)
 * Space: O(n)
 */