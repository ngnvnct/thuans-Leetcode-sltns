import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class min_remove_valid_parentheses {
    public String minRemoveToMakeValidReverse(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        StringBuilder res = new StringBuilder();
        for (int i = sb.length()-1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && open-- > 0) {
                continue;
            }
            res.append(c);
        }
        return res.reverse().toString();
    }

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                balance++;
            } else if (c == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }

        int keep = open-balance;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                //keep--;
                if (--keep < 0) {
                    continue;
                }
            }
            res.append(c);
        }
        return res.toString();
    }
    @Test
    public void testMinRemove() {
        String one = "a)b(c)d(((";
        String two = "lee(t(c)o)de)";
        String three = "))((";

        assertEquals("ab(c)d", minRemoveToMakeValid(one));
        assertEquals("ab(c)d", minRemoveToMakeValidReverse(one));
        assertEquals("lee(t(c)o)de", minRemoveToMakeValid(two));
        assertEquals("lee(t(c)o)de", minRemoveToMakeValidReverse(two));
        assertEquals("", minRemoveToMakeValid(three));
        assertEquals("", minRemoveToMakeValidReverse(three));
    }
}

/*abstract
Explanation

Loop backward because we don't want to remove balance parentheses, we remove excess (
()(;
)(;

Backward, we are going to two pass. The first pass, we want to remove all the excessive close parentheses that do not result in a balance parentheses. So if open == 0, we continue, skipping it
When the loop terminate, we will have a string with mostly balance parentheses, except for cases where have a lots of open parentheses

Then, we want loop backward, and remove the excessive open parentheses, and build a new string. Return a reverse of it

Unnessary backward, we can do everything forward, we keep a variable call balance, and we can keep the excessive
open parentheses by doing open-balance, then we know exactly how many to remove

Time: O(n) where n is the length of the input string
Space: O(n) where n is the length of the input string
*/