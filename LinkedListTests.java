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
        ListNode exampleOne = new ListNode(2);
        addMany(exampleOne, new ArrayList<>(Arrays.asList(6, 7, 8)));
        ListNode exampleTwo = new ListNode(1);
        addMany(exampleTwo, new ArrayList<>(Arrays.asList(3, 4, 5, 9, 10)));
        ListNode output = Merge_Two_Sorted_Lists_21.mergeTwoLists(exampleOne, exampleTwo);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleThree = null;
        ListNode exampleFour = null;
        output = Merge_Two_Sorted_Lists_21.mergeTwoLists(exampleThree, exampleFour);
        expectedNodes = new ArrayList<>(Arrays.asList());
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleSix = null;
        ListNode exampleSeven = new ListNode(0);
        output = Merge_Two_Sorted_Lists_21.mergeTwoLists(exampleSix, exampleSeven);
        expectedNodes = new ArrayList<>(Arrays.asList(0));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testOddEvenLinkedList() {
        ListNode exampleOne = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = odd_even_linked_list.oddEvenList(exampleOne);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 3, 5, 2, 4));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleTwo = addMany(new ListNode(2), new ArrayList<>(Arrays.asList(1, 3, 5, 6, 4, 7)));
        output = odd_even_linked_list.oddEvenList(exampleTwo);
        expectedNodes = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 1, 5, 4));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testPalindromeLinkedList() {
        ListNode exampleOne = new ListNode(1);
        addMany(exampleOne, new ArrayList<>(Arrays.asList(2, 2, 1)));
        boolean output = Palindrome_Linked_List_234.isPalindrome(exampleOne);
        assertTrue(output == true);

        ListNode exampleTwo = new ListNode(1);
        addMany(exampleTwo, new ArrayList<>(Arrays.asList(2)));
        output = Palindrome_Linked_List_234.isPalindrome(exampleTwo);
        assertTrue(output == false);
    }

    @Test
    public void testReverseLinkedList() {
        ListNode exampleOne = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = Reverse_Linked_List_206.reverseListRecursive(exampleOne);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleTwo = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2)));
        output = Reverse_Linked_List_206.reverseList(exampleTwo);
        expectedNodes = new ArrayList<>(Arrays.asList(2, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleThree = null;
        output = Reverse_Linked_List_206.reverseList(exampleThree);
        expectedNodes = new ArrayList<Integer>(Arrays.asList());
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testAddTwoLinkedLists() {
        ListNode exampleOne = addMany(new ListNode(2), new ArrayList<>(Arrays.asList(4, 3)));
        ListNode exampleTwo = addMany(new ListNode(5), new ArrayList<>(Arrays.asList(6, 4)));
        ListNode output = Add_Two_Numbers_2.addTwoNumbers(exampleOne, exampleTwo);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(7, 0, 8));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        // 2nd way to test
        ListNode expectedNodes2 = addMany(new ListNode(7), new ArrayList<>(Arrays.asList(0, 8)));
        assertTrue(getNodesInArray(expectedNodes2).equals(getNodesInArray(output)));

        ListNode exampleThree = addMany(new ListNode(9), new ArrayList<>(Arrays.asList(9)));
        ListNode exampleFour = new ListNode(1);
        output = Add_Two_Numbers_2.addTwoNumbers(exampleThree, exampleFour);
        expectedNodes = new ArrayList<>(Arrays.asList(0, 0, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testMiddleLinkedList() {
        ListNode exampleOne = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = middle_linked_list.middleNode(exampleOne);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(3, 4, 5));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleTwo = addMany(new ListNode(1), new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));
        output = middle_linked_list.middleNode(exampleTwo);
        expectedNodes = new ArrayList<>(Arrays.asList(4, 5, 6));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }
}