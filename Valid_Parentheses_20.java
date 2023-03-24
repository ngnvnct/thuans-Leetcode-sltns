import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class Valid_Parentheses_20 {
    public boolean isValidStack(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

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

    public boolean isValidDeque(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst(')');
            } else if (c == '[') {
                stack.addFirst(']');
            } else if (c == '{') {
                stack.addFirst('}');
            } else if (stack.isEmpty() || stack.removeFirst() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidIllegalChar(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.addFirst(map.get(c));
            } else if (map.containsValue(c)) {
                if (stack.isEmpty() || stack.removeFirst() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testParentheses() {
        String testCase1 = "(){}[]";
        String testCase2 = "()";
        String testCase3 = "(]";
        String testCase4 = "(a)";
        String testCase5 = "(141[])(){waga}((51afaw))()hh()";
        String testCase6 = "(()agwg())((()agwga()())gawgwgag)";
        String testCase7 = "(agwgg)([ghhheah%&@Q])";

        assertTrue(isValidStack(testCase1));
        assertTrue(isValidStack(testCase2));
        assertFalse(isValidStack(testCase3));

        assertTrue(isValidDeque(testCase1));
        assertTrue(isValidDeque(testCase2));
        assertFalse(isValidDeque(testCase3));

        assertTrue(isValidIllegalChar(testCase1));
        assertTrue(isValidIllegalChar(testCase2));
        assertFalse(isValidIllegalChar(testCase3));
        assertTrue(isValidIllegalChar(testCase4));

        assertTrue(isValidIllegalChar(testCase5));
        assertTrue(isValidIllegalChar(testCase6));
        assertTrue(isValidIllegalChar(testCase7));
    }
}

/*
 * https://leetcode.com/problems/valid-parentheses/
 * Explanation
 * 
 * A simple stack problem, if it is (,[ or { then push it onto the stack. Then
 * if it is ), ], } peek the stack and if they match then pop it out. Finally,
 * see if the stack is empty
 * 
 * Method 2: if you see (, [, { push these onto the stack },],) then pop them
 * and check it with the current to see if it matches
 * 
 * You can just exist early if the length of the string is odd
 * 
 * Time: O(n), optimal is not optimal since containsValue() is an O(n)
 * operation, but in this case it is constant so it is okay
 * Space: O(n)
 * 
 * For Java: Using Stack shows that you're not as familiar with language as the
 * interviewer probably wants you to be.
 * Stack is a rather old collection that extends Vector, has performance issues
 * due to each method in it being synchronized,
 * and violates some best practices around interfaces, so it is considered
 * legacy nowadays.
 * 
 * The most optimal way is using a hashmap, because the other two does not
 * account for each that contains Characters, Numbers or Special Symbols
 * 
 * https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
 * Use Deque instead
 * https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
 */