package linked_list;

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
}
