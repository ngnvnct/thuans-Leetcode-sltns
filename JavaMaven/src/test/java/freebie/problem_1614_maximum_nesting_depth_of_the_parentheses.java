/*
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * Explanation:
 * 
 * Ask by Facebook Phone
 * A naive solution is to use a stack, don't do that.
 * Just ignore digits and signs and only count the ( or )
 * Keep a variable currMax that is the Math.max of current max and max depth,
 * everytime you see an open, you increment currMax and update a new max
 * If you see a close parentheses, decrement curr max
 * 
 * Not on leetcode, a facebook constraint is if a parentheses is unbalance,
 * return -1, we have that if condition in the loop to terminate early
 * At the end of the loop, we have to check if currMax is 0, if it is not zero
 * that means it is unbalance, return -1
 * 
 * Time: O(n)
 * Space: O(1)
 */

package freebie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_1614_maximum_nesting_depth_of_the_parentheses {
    public int maxDepth(String s) {
        int currMax = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                currMax++;
                maxDepth = Math.max(currMax, maxDepth);
            } else if (c == ')') {
                currMax--;
                if (currMax < 0) {
                    return -1;
                }
            }
        }
        if (currMax != 0) {
            return -1;
        }
        return maxDepth;
    }

    @Test
    public void testDepth() {
        String testCase1 = "(1+(2*3)+((8)/4))+1";
        int testCase1ExpectedResult = 3;
        String testCase2 = "(1)+((2))+(((3)))";
        int testCase2ExpectedResult = 3;
        String testCase3 = "8*((1*(5+6))*(8/6))";
        int testCase3ExpectedResult = 3;
        String testCase4 = "((())";
        int testCase4ExpectedResult = -1;

        assertEquals(testCase1ExpectedResult, maxDepth(testCase1));
        assertEquals(testCase2ExpectedResult, maxDepth(testCase2));
        assertEquals(testCase3ExpectedResult, maxDepth(testCase3));
        assertEquals(testCase4ExpectedResult, maxDepth(testCase4));
    }
}