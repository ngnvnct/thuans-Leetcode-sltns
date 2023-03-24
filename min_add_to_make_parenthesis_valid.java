import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

public class min_add_to_make_parenthesis_valid {

    public int minAddToMakeValidStack(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.addFirst(c);
            } else if (c == ')' && stack.isEmpty()) {
                ++count;
            } else {
                stack.pop();
            }
        }
        return count + stack.size();
    }

    public int minAddToMakeValid(String s) {
        int needLeft = 0;
        int needRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                needRight++;
            } else if (c == ')' && needRight > 0) {
                needRight--;
            } else {
                needLeft++;
            }
        }
        return needLeft + needRight;
    }

    @Test
    public void testValid() {
        assertEquals(1, minAddToMakeValid("())"));
        assertEquals(5, minAddToMakeValid("())))))"));
        assertEquals(4, minAddToMakeValid("(((("));
    }
}

/*
Explanation
Keep 2 counts variable, if we encounter a "(", we increment needRight
else if we encounter a ")", we check if a "(" count is already present, we decrement needRight
else we only encounter ")" so far, we have to increment needLeft to match it
return needLeft + needRight

Time: O(n)
Space: O(1)
*/