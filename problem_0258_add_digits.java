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

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
        
        assertEquals(testCase1ExpectedResult, addDigitIteration(testCase1));
        assertEquals(testCase1ExpectedResult, addDigitMath(testCase1));
        assertEquals(0, addDigitMath(testCase1));
    }
}