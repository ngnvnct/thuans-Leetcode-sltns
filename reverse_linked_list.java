
public class reverse_linked_list {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

/*
https://leetcode.com/problems/reverse-linked-list/
Explanation
A simple reverse LL problem

Time: O(n)
Space: O(1) for iterative, O(n) for recursive

Write the test case in LinkedListTest.java
*/
