/*
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 * Explanation:
 * 
 * Operations[i] will be either "++X", "X++", "--X", or "X--"
 * 
 * Because of this constraint, it will always be a valid input. Therefore, we
 * can just check the 1st index whether it is '-' or '+', then update
 * accordingly
 * Or, just take care of one operation "++X", "X++" using equals() method
 * 
 * Time: O(n)
 * Space: O(1)
 */

package Java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_2011_final_value_of_variable_after_performing_operations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            char[] c = operation.toCharArray();
            if (c[1] == '-') {
                x--;
            } else {
                x++;
            }
        }
        return x;
    }

    public int finalValueAfterOperations2(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    @Test
    public void testOperations() {
        String[] testCase1 = { "--X", "X++", "X++" };
        int testCase1ExpectedResult = 1;
        String[] testCase2 = { "++X", "++X", "X++" };
        int testCase2ExpectedResult = 3;
        String[] testCase3 = { "X++", "++X", "--X", "X--" };
        int testCase3ExpectedResult = 0;

        assertEquals(testCase1ExpectedResult, finalValueAfterOperations(testCase1));
        assertEquals(testCase2ExpectedResult, finalValueAfterOperations(testCase2));
        assertEquals(testCase3ExpectedResult, finalValueAfterOperations(testCase3));

        assertEquals(testCase1ExpectedResult, finalValueAfterOperations2(testCase1));
        assertEquals(testCase2ExpectedResult, finalValueAfterOperations2(testCase2));
        assertEquals(testCase3ExpectedResult, finalValueAfterOperations2(testCase3));
    }
}
