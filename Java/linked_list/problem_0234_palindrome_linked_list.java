/*
 * https://leetcode.com/problems/palindrome-linked-list/
 * Explanation:
 * 
 * Use a stack, push all element onto the stack, then pop it and check it with
 * the current value
 * 
 * Time: O(n)
 * Space: O(n)
 * 
 * Write the test case in LinkedListTests.java
 */

package linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class problem_0234_palindrome_linked_list {
    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.addFirst(temp.value);
            temp = temp.next;
        }
        while (head != null) {
            if (stack.removeFirst() != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    @Test
    public void testPalindromeLinkedList() {
        ListNode node = new ListNode();
        ListNode testCase1 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 2, 1)));
        boolean output = problem_0234_palindrome_linked_list.isPalindrome(testCase1);
        assertTrue(output);

        ListNode testCase2 = node.addMany(new ListNode(1),new ArrayList<>(Arrays.asList(2)));
        output = problem_0234_palindrome_linked_list.isPalindrome(testCase2);
        assertFalse(output);
    }
}