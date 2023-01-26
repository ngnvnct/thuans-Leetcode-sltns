package linked_list;

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
}
