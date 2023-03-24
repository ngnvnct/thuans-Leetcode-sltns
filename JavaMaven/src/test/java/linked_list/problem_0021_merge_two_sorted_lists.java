/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Explanation:
 * 
 * We use a dummy node, and which value is smaller, we take it and point it to
 * the dummy node
 * 1->2->4
 * 1->3->4->5->6
 * if we exhaust a list, another list can have still have some values after it,
 * in that case, we just point our dummy.next to l2, and vice versa
 * 
 * Time: O(n + m)
 * Space: O(1)
 */

package linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class problem_0021_merge_two_sorted_lists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
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

    @Test
    public void testMergeTwoSortedLists() {
        ListNode node = new ListNode();
        ListNode testCase1FirstList = new ListNode(2);
        node.addMany(testCase1FirstList, new ArrayList<>(Arrays.asList(6, 7, 8)));
        ListNode testCase1SecondList = new ListNode(1);
        node.addMany(testCase1SecondList, new ArrayList<>(Arrays.asList(3, 4, 5, 9, 10)));
        ListNode output = problem_0021_merge_two_sorted_lists.mergeTwoLists(testCase1FirstList, testCase1SecondList);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));

        ListNode testCase2FirstList = null;
        ListNode testCase2SecondList = null;
        output = problem_0021_merge_two_sorted_lists.mergeTwoLists(testCase2FirstList, testCase2SecondList);
        expectedNodes = new ArrayList<>(Arrays.asList());
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));

        ListNode testCase3FirstList = null;
        ListNode testCase3SecondList = new ListNode(0);
        output = problem_0021_merge_two_sorted_lists.mergeTwoLists(testCase3FirstList, testCase3SecondList);
        expectedNodes = new ArrayList<>(Arrays.asList(0));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
    }
}