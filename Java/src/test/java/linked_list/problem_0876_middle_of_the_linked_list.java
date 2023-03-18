/*
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Explanation:
 * 
 * Two pointers, one fast and one slow, fast goes two steps and slow goes one
 * step
 * when fast becomes null, slow will be in the middle of the linked list
 * we return slow
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 */

package linked_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class problem_0876_middle_of_the_linked_list {
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void testMiddleLinkedList() {
        ListNode node = new ListNode();
        ListNode testCase1 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0876_middle_of_the_linked_list.middleNode(testCase1);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(3, 4, 5));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
        assertEquals(node.getNodesInArray(output), expectedNodes);

        ListNode testCase2 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));
        output = problem_0876_middle_of_the_linked_list.middleNode(testCase2);
        expectedNodes = new ArrayList<>(Arrays.asList(4, 5, 6));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
        assertEquals(node.getNodesInArray(output), expectedNodes);
    }
}