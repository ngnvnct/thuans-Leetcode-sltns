public class merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while( l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return head.next;
    }
}


/*
https://leetcode.com/problems/merge-two-sorted-lists/
Explanation

We use a dummy node, and which value is smaller, we take it and point it to the dummy node
1->2->4
1->3->4->5->6
if we exhaust a list, another list can have still have some values after it, in that case, we just point our dummy.next to l2, and vice versa

Time: O(n + m)
Space: O(1)
*/