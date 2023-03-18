/*
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Explanation:
 * 
 * 1->2->3->4->5->6->7
 *       ^           |
 *       |           v
 *        11<-10<-9<-8
 * 
 * In the first loop
 * Fast: 1->3->5->7->9->11->4->6->8->10
 * Slow: 1->2->3->4->5->06->7->8->9->10
 * Break cycle detected, now slow is at 10
 * 
 * Target: 1->2->3
 * Slow: 10->11->3
 * We find the cycle
 * 
 * Time: O(n)
 * Space: O(1)
 */

package linked_list;

import java.util.HashSet;
import java.util.Set;

public class problem_0142_linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            ListNode cycleBegin = head;
            while (cycleBegin != slow) {
                cycleBegin = cycleBegin.next;
                slow = slow.next;
            }
            return cycleBegin;
        }
        return null;
    }

    public ListNode detectCycleSet(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            visited.add(temp);
            temp = temp.next;
        }
        return null;
    }
}