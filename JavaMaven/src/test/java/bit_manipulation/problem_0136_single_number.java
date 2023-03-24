/*
 * https://leetcode.com/problems/single-number/
 * Explanation:
 * 
 * This is a bit manipulation problem. ^= is XOR, the integer becomes binary
 * representation, and XOR will calculate as
 * 1 ^ 0 = 1
 * 0 ^ 1 = 1
 * 1 ^ 1 = 0
 * 0 ^ 0 = 0
 * If you XOR the exact same number, they will become 0 in the output.
 * 
 * Time: O(n)
 * Space: O(1)
 */

package bit_manipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_0136_single_number {
    public int singleNumber(int[] nums) {
        int bitWise = 0;
        for (int num : nums) {
            bitWise ^= num;
        }
        return bitWise;
    }

    @Test
    public void testSingleNumber() {
        int[] testCase1 = { 2, 2, 1 };
        int testCase1ExpectedResult = 1;
        int[] testCase2 = { 4, 1, 2, 1, 2 };
        int testCase2ExpectedResult = 4;
        int[] testCase3 = { 1 };
        int testCase3ExpectedResult = 1;
        int[] testCase4 = { 3, 3, 7, 8, 7 };
        int testCase4ExpectedResult = 8;
        int[] testCase5 = { 0, 0, 1, 2, 1 };
        int testCase5ExpectedResult = 2;

        assertEquals(testCase1ExpectedResult, singleNumber(testCase1));
        assertEquals(testCase2ExpectedResult, singleNumber(testCase2));
        assertEquals(testCase3ExpectedResult, singleNumber(testCase3));
        assertEquals(testCase4ExpectedResult, singleNumber(testCase4));
        assertEquals(testCase5ExpectedResult, singleNumber(testCase5));
    }
}