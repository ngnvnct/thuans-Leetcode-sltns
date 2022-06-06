import java.util.HashSet;
import java.util.Set;

public class intersection_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInB = new HashSet<>();
        
        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            if (nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
Explanation

Hash: Traverse list B and stores the address of each node in a hash set. Then in Node headA checks if that node exists in the hash set. Return if it does
If we reach the end and found nothing, return null. Note: we comparing Node and not values within the nodes

Time: O(n + m), Space: O(m) where n is the length of node A and m is the length of node B

Two Pointers Space Optimized: 
         a
   |------------|         c 
                |-----------------|
|---------------|
        b
c is the shared part, a is exclusive part of list A and b is exclusive part of list B, we can have one pointer that goes over a + c + b and the other that goes over b + c + a
one pointer measures the length of the longer list, and the other measure the shorter list, and then placing the start pointer for the longer list
then both are stepping through the list together.

Time: O(n + m) 
Space: O(1)
*/