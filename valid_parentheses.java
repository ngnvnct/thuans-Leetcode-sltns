import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class valid_parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testParentheses() {
        assertEquals(true, isValid("(){}[]"));
        assertEquals(true, isValid("()"));
        assertEquals(false, isValid("(]"));
        assertEquals(true, isValid2("(){}[]"));
        assertEquals(true, isValid2("()"));
        assertEquals(false, isValid2("(]"));
    }
}

/*
Explanation

A simple stack problem, if it is (,[ or { then push it onto the stack. Then if it is ), ], } peek the stack and if they match then pop it out. Finally, see if the stack is empty

Method 2: if you see (, [, { push these onto the stack },],) then pop them and check it with the current to see if it matches

Time: O(n) 
Space: O(n)

*/