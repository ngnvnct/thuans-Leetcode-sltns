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
    public void testMergeTwoSortedLists() {
        ListNode testCase1 = new ListNode(2);
        addMany(testCase1, new ArrayList<>(Arrays.asList(6, 7, 8)));
        ListNode testCase2 = new ListNode(1);
        addMany(testCase2, new ArrayList<>(Arrays.asList(3, 4, 5, 9, 10)));
        ListNode output = problem_0021_merge_two_sorted_lists.mergeTwoLists(testCase1, testCase2);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode testCase3 = null;
        ListNode testCase4 = null;
        output = problem_0021_merge_two_sorted_lists.mergeTwoLists(testCase3, testCase4);
        expectedNodes = new ArrayList<>(Arrays.asList());
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode testCase6 = null;
        ListNode testCase7 = new ListNode(0);
        output = problem_0021_merge_two_sorted_lists.mergeTwoLists(testCase6, testCase7);
        expectedNodes = new ArrayList<>(Arrays.asList(0));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testOddEvenLinkedList() {
        ListNode testCase1 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0328_odd_even_linked_list.oddEvenList(testCase1);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 3, 5, 2, 4));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode testCase2 = addMany(new ListNode(2), new ArrayList<>(Arrays.asList(1, 3, 5, 6, 4, 7)));
        output = problem_0328_odd_even_linked_list.oddEvenList(testCase2);
        expectedNodes = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 1, 5, 4));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testPalindromeLinkedList() {
        ListNode testCase1 = new ListNode(1);
        addMany(testCase1, new ArrayList<>(Arrays.asList(2, 2, 1)));
        boolean output = problem_0234_palindrome_linked_list.isPalindrome(testCase1);
        assertTrue(output == true);

        ListNode testCase2 = new ListNode(1);
        addMany(testCase2, new ArrayList<>(Arrays.asList(2)));
        output = problem_0234_palindrome_linked_list.isPalindrome(testCase2);
        assertTrue(output == false);
    }

    @Test
    public void testReverseLinkedList() {
        ListNode testCase1 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = problem_0206_reverse_linked_list.reverseListRecursive(testCase1);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode testCase2 = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2)));
        output = problem_0206_reverse_linked_list.reverseList(testCase2);
        expectedNodes = new ArrayList<>(Arrays.asList(2, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode testCase3 = null;
        output = problem_0206_reverse_linked_list.reverseList(testCase3);
        expectedNodes = new ArrayList<Integer>(Arrays.asList());
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testAddTwoLinkedLists() {
        ListNode testCase1 = addMany(new ListNode(2), new ArrayList<>(Arrays.asList(4, 3)));
        ListNode testCase2 = addMany(new ListNode(5), new ArrayList<>(Arrays.asList(6, 4)));
        ListNode output = problem_0002_add_two_numbers.addTwoNumbers(testCase1, testCase2);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(7, 0, 8));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        // 2nd way to test
        ListNode expectedNodes2 = addMany(new ListNode(7), new ArrayList<>(Arrays.asList(0, 8)));
        assertTrue(getNodesInArray(expectedNodes2).equals(getNodesInArray(output)));

        ListNode testCase3 = addMany(new ListNode(9), new ArrayList<>(Arrays.asList(9)));
        ListNode testCase4 = new ListNode(1);
        output = problem_0002_add_two_numbers.addTwoNumbers(testCase3, testCase4);
        expectedNodes = new ArrayList<>(Arrays.asList(0, 0, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
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