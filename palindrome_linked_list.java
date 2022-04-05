import java.util.Stack;

public class palindrome_linked_list {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }   
        return true;
    }
}

/*
Explanation
Use a stack, push all element onto the stack, then pop it and check it with the current value

Time: O(n)
Space: O(n)
*/