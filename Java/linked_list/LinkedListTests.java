package linked_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LinkedListTests {
    public ListNode addMany(ListNode ll, List<Integer> values) {
        ListNode current = ll;
        while (current.next != null) {
            current = current.next;
        }

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(ListNode ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        ListNode current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }
    
    @Test
    public void testMiddleLinkedList() {
        ListNode testCase1 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0876_middle_of_the_linked_list.middleNode(testCase1);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(3, 4, 5));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
        assertEquals(getNodesInArray(output), expectedNodes);

        ListNode testCase2 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));
        output = problem_0876_middle_of_the_linked_list.middleNode(testCase2);
        expectedNodes = new ArrayList<>(Arrays.asList(4, 5, 6));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
        assertEquals(getNodesInArray(output), expectedNodes);
    }

    @Test
    public void testReverseLinkedListII() {
        ListNode testCase1 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0092_reverse_linked_list_ii.reverseBetween(testCase1, 2, 4);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
        assertEquals(getNodesInArray(output), expectedNodes);

        ListNode testCase2 = new ListNode(5);
        output = problem_0092_reverse_linked_list_ii.reverseBetween(testCase2, 1, 1);
        expectedNodes = new ArrayList<>(Arrays.asList(5));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
        assertEquals(getNodesInArray(output), expectedNodes);
    }

    @Test
    public void testParitionList() {
        ListNode testCase1 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(4, 3, 2, 5, 2)));
        ListNode output = problem_0086_parition_list.partition(testCase1, 3);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 3, 5));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
        // 2nd way to test, this one gives me the value of the LinkedList
        assertEquals(getNodesInArray(output), expectedNodes);

        ListNode testCase2 = addMany(new ListNode(2), new ArrayList<>(Arrays.asList(1)));
        output = problem_0086_parition_list.partition(testCase2, 2);
        expectedNodes = new ArrayList<>(Arrays.asList(1, 2));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
        assertEquals(getNodesInArray(output), expectedNodes);
    }
}