import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Remove_Duplicate_Letters_316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peekFirst() && lastOccurence.get(stack.peekFirst()) > i) {
                    seen.remove(stack.removeFirst());
                }
                seen.add(c);
                stack.addFirst(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    @Test
    public void testDuplicate() {
        String exampleOne = "bcabc";
        String exampleOneExpectedResult = "abc";
        String exampleTwo = "cbacdcbc";
        String exampleTwoExpectedResult = "acdb";

        assertEquals(exampleOneExpectedResult, removeDuplicateLetters(exampleOne));
        assertEquals(exampleTwoExpectedResult, removeDuplicateLetters(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/remove-duplicate-letters/
 * Explanation, greedy solve with stack
 * 
 * A stack to store the solution currently built, and delete characters off the
 * stack whenever it is possible to make it smaller
 * Each iteration we add the current character to the solution if it hasn't
 * already been used. Remove as many characters as possible off the top of the
 * stack, and then add the current character
 * Condition for deletion rae:
 * The character is greater than the current character
 * The character can be removed because it occurs later on
 * At each stage, we greedily keep what's on the stack as small as possible.
 * 
 * A set to keep track what's in the solution in O(1) time
 * A hash map to keep track if there are any more instances of s[i] left in s
 * 
 * 
 * String - "cbacdcbc"
 * Stack - "c", "cb"
 * "b" < "c", and there are other occurrences of "c" later, pop from the stack
 * 
 * Stack - "ba", remove b since there are other occurences of "b" later
 * Stack "acd", skip the next c
 * Stack "acdb", skip the next c
 * return result
 * 
 * Time: O(n)
 * Space: O(1), since there are only 26 letters in the alphabet, it is bounded
 * by the constants value
 */