package linked_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class problem_0092_reverse_linked_list_ii {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = dummy.next;
        int i = 1;

        while (i < left) {
            leftPrev = curr;
            curr = curr.next;
            i++;
        }

        ListNode prev = null;
        while (i <= right) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
            i++;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }

    @Test
    public void testReverseLinkedListII() {
        ListNode node = new ListNode();
        ListNode testCase1 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0092_reverse_linked_list_ii.reverseBetween(testCase1, 2, 4);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
        assertEquals(node.getNodesInArray(output), expectedNodes);

        ListNode testCase2 = new ListNode(5);
        output = problem_0092_reverse_linked_list_ii.reverseBetween(testCase2, 1, 1);
        expectedNodes = new ArrayList<>(Arrays.asList(5));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
        assertEquals(node.getNodesInArray(output), expectedNodes);
    }
}
