package linked_list;

import java.util.ArrayList;
import java.util.List;

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
}