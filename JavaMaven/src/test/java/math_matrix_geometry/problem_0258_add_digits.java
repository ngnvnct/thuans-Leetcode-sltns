/*
 * https://leetcode.com/problems/add-digits/
 * 
 * Explanation:
 * 
 * Iteration way while n is greater than 9, meaning there are more than one
 * digit, just add them until it becomes 1 digit
 * 38 mod 10 = 8, 38/10 + 8 = 11
 * 11 mod 10 = 1, 11/10 + 1 = 2, return 2
 * Digit Root Math way, use a formula
 * 
 * Time: O(n) or O(1)
 * Space: O(1)
 */

package math_matrix_geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_0258_add_digits {
    public int addDigitIteration(int n) {
        while (n > 9) {
            int temp = n % 10;
            n = n / 10 + temp;
        }
        return n;
    }

    public int addDigitMath(int n) {
        if (n == 0) {
            return 0;
        } else if (n % 9 == 0) {
            return 9;
        } else {
            return n % 9;
        }
    }

    @Test
    public void testAddDigit() {
        int testCase1 = 38;
        int testCase1ExpectedResult = 2;
        int testCase2 = 12345;
        int testCase2ExpectedResult = 6;
        int testCase3 = 0;
        int testCase3ExpectedResult = 0;
        int testCase4 = 9;
        int testCase4ExpectedResult = 9;
        int testCase5 = 99999;
        int testCase5ExpectedResult = 9;

        assertEquals(testCase1ExpectedResult, addDigitIteration(testCase1));
        assertEquals(testCase1ExpectedResult, addDigitMath(testCase1));
        assertEquals(testCase2ExpectedResult, addDigitIteration(testCase2));
        assertEquals(testCase2ExpectedResult, addDigitMath(testCase2));
        assertEquals(testCase3ExpectedResult, addDigitIteration(testCase3));
        assertEquals(testCase3ExpectedResult, addDigitMath(testCase3));
        assertEquals(testCase4ExpectedResult, addDigitIteration(testCase4));
        assertEquals(testCase4ExpectedResult, addDigitMath(testCase4));
        assertEquals(testCase5ExpectedResult, addDigitIteration(testCase5));
        assertEquals(testCase5ExpectedResult, addDigitMath(testCase5));
    }
}