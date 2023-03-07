import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Minimum_Remove_To_Make_Valid_Parentheses_1249 {
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
        for (int i = sb.length() - 1; i >= 0; i--) {
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

        int keep = open - balance;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                // keep--;
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
        String testCase1 = "a)b(c)d(((";
        String testCase1ExpectedResult = "ab(c)d";
        String testCase2 = "lee(t(c)o)de)";
        String testCase2ExpectedResult = "lee(t(c)o)de";
        String testCase3 = "))((";
        String testCase3ExpectedResult = "";

        assertEquals(testCase1ExpectedResult, minRemoveToMakeValid(testCase1));
        assertEquals(testCase2ExpectedResult, minRemoveToMakeValid(testCase2));
        assertEquals(testCase3ExpectedResult, minRemoveToMakeValid(testCase3));

        assertEquals(testCase1ExpectedResult, minRemoveToMakeValidReverse(testCase1));
        assertEquals(testCase2ExpectedResult, minRemoveToMakeValidReverse(testCase2));
        assertEquals(testCase3ExpectedResult, minRemoveToMakeValidReverse(testCase3));
    }
}

/*
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Explanation
 * 
 * Loop backward because we don't want to remove balance parentheses, we remove
 * excess (
 * ()(;
 * )(;
 * 
 * Backward, we are going to two pass. The first pass, we want to remove all the
 * excessive close parentheses that do not result in a balance parentheses. So
 * if open == 0, we continue, skipping it
 * When the loop terminate, we will have a string with mostly balance
 * parentheses, except for cases where have a lots of open parentheses
 * 
 * Then, we want loop backward, and remove the excessive open parentheses, and
 * build a new string. Return a reverse of it
 * 
 * Unnessary backward, we can do everything forward, we keep a variable call
 * balance, and we can keep the excessive
 * open parentheses by doing open-balance, then we know exactly how many to
 * remove
 * 
 * Time: O(n) where n is the length of the input string
 * Space: O(n) where n is the length of the input string
 */