package linked_list;

public class problem_0237_deletes_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
