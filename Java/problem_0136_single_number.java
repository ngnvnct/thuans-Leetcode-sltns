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

package Java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
        int[] testCase1ExpectedResult = { 2, 2, 1 };
        int[] testCase2ExpectedResult = { 4, 1, 2, 1, 2 };
        int[] testCase3ExpectedResult = { 1 };

        assertEquals(1, singleNumber(testCase1ExpectedResult));
        assertEquals(4, singleNumber(testCase2ExpectedResult));
        assertEquals(1, singleNumber(testCase3ExpectedResult));
    }
}