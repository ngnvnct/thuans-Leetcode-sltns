public class Odd_Even_Linked_List_328 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode evenHead = evenList;

        while (evenList != null && evenList.next != null) {
            oddList.next = oddList.next.next;
            evenList.next = evenList.next.next;
            oddList = oddList.next;
            evenList = evenList.next;
        }
        oddList.next = evenHead;
        return head;
    }
}

/*
 * https://leetcode.com/problems/odd-even-linked-list/
 * Explanation
 * 
 * A well-formed LinkedList need two pointers head and tail to support
 * operations at both ends.
 * The variables head and odd are the head pointer and tail pointer of one
 * LinkedList we call oddList;
 * the variables evenHead and even are the head pointer and tail pointer of
 * another LinkedList we call evenList.
 * The algorithm traverses the original LinkedList and put the odd nodes into
 * the oddList and the even nodes into the evenList.
 * To traverse a LinkedList we need at least one pointer as an iterator for the
 * current node.
 * But here the pointers odd and even not only serve as the tail pointers but
 * also act as the iterators of the original list.
 * 
 * Dry Run
 * 1 -> 2 - > 3 -> 4 -> 5
 * 
 * head = 1 -> 2 - > 3 -> 4 -> 5
 * oddList = 1 -> 2 - > 3 -> 4 -> 5
 * evenList = 2 - > 3 -> 4 -> 5
 * evenHead = 2 - > 3 -> 4 -> 5
 * 
 * First Run
 * head = 1 -> 3 -> 4 -> 5
 * oddlist = 1 -> 3 -> 4 -> 5
 * evenList = 2 -> 4 - > 5
 * evenhead = 2 -> 4 -> 5
 * 
 * head = 1 -> 3 -> 4 -> 5
 * oddlist = 3 -> 4 -> 5
 * evenList = 4 - > 5
 * evenhead = 2 -> 4 -> 5
 * 
 * Second Run
 * head = 1 -> 3 -> 5
 * oddList = 3 -> 5
 * evenList = 4
 * evenHead = 2 -> 4
 * 
 * oddList = 5
 * evenList = null
 * evenHead = 2 -> 4
 * 
 * oddList = evenHead
 * 5 -> 2 -> 4
 * 
 * head = 1 -> 3 -> 5 -> 2 -> 4
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * Write the test case in LinkedListTests.java
 */