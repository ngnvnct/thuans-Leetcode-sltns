/*
 * https://leetcode.com/problems/reverse-linked-list/
 * Explanation:
 * 
 * A simple reverse LL problem
 * 
 * Time: O(n)
 * Space: O(1) for iterative, O(n) for recursive
 * 
 * Write the test case in LinkedListTest.java
 */

package linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class problem_0206_reverse_linked_list {
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

    @Test
    public void testReverseLinkedList() {
        ListNode node = new ListNode();
        ListNode testCase1 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0206_reverse_linked_list.reverseListRecursive(testCase1);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));

        ListNode testCase2 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2)));
        output = problem_0206_reverse_linked_list.reverseList(testCase2);
        expectedNodes = new ArrayList<>(Arrays.asList(2, 1));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));

        ListNode testCase3 = null;
        output = problem_0206_reverse_linked_list.reverseList(testCase3);
        expectedNodes = new ArrayList<Integer>(Arrays.asList());
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
    }
}
