package linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class problem_0086_parition_list {
    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode leftTail = left;
        ListNode rightTail = right;
        while (head != null) {
            if (head.value < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = right.next;
        return left.next;
    }

    @Test
    public void testParitionList() {
        ListNode node = new ListNode();
        ListNode testCase1 = node.addMany(new ListNode(1), new ArrayList<>(Arrays.asList(4, 3, 2, 5, 2)));
        ListNode output = problem_0086_parition_list.partition(testCase1, 3);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 3, 5));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
        // 2nd way to test, this one gives me the value of the LinkedList
        assertEquals(node.getNodesInArray(output), expectedNodes);

        ListNode testCase2 = node.addMany(new ListNode(2), new ArrayList<>(Arrays.asList(1)));
        output = problem_0086_parition_list.partition(testCase2, 2);
        expectedNodes = new ArrayList<>(Arrays.asList(1, 2));
        assertTrue(node.getNodesInArray(output).equals(expectedNodes));
        assertEquals(node.getNodesInArray(output), expectedNodes);
    }
}
