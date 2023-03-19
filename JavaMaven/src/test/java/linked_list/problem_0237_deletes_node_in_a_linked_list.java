/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Explantion:
 * 
 * Store the next node in a temporary variable
 * Copy data of the next node to the current node
 * Change the next pointer of the current node to the next pointer of the next node
 * 
 * Time: O(1)
 * Space: O(1)
 */

package linked_list;

public class problem_0237_deletes_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.value = nextNode.value;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
