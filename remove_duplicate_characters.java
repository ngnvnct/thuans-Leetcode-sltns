import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class remove_duplicate_characters {
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
                while(!stack.isEmpty() && c < stack.peekFirst() && lastOccurence.get(stack.peekFirst()) > i) {
                    seen.remove(stack.removeFirst());
                }
                seen.add(c);
                stack.addFirst(c);
            }
        }
        StringBuilder sb=  new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    @Test
    public void testDuplicate() {
        String one = "bcabc";
        String expectedOne = "abc";
        String two = "cbacdcbc";
        String expectedTwo = "acdb";

        assertEquals(expectedOne, removeDuplicateLetters(one));
        assertEquals(expectedTwo, removeDuplicateLetters(two));
    }
}

/*
Explanation
Keep a stack, a set of seen character, and the last occurence map which store key character and value index



Time: O(n)
Space: O(1), since there are only 26 letters in the alphabet, it is bounded by the constants value
*/