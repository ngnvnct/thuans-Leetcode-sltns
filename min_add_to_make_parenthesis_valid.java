import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class min_add_to_make_parenthesis_valid {
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

/*abstract
Explanation
Keep 2 counts variable, if we encounter a "(", we increment needRight
else if we encoutner a ")", we check if a "(" count is already present, we decrement needRight
else we only encounter ")" so far, we have to increment needLeft to match it
return needLeft + needRight

Time: O(n)
Space: O(1)
*/