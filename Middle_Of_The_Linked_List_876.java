public class Middle_Of_The_Linked_List_876 {
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

/*
 * Part of Leetcode75
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Explanation
 * 
 * Two pointers, one fast and one slow, fast goes two steps and slow goes one
 * step
 * when fast becomes null, slow will be in the middle of the linked list
 * we return slow
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * Write the test in LinkedListTests.java
 */