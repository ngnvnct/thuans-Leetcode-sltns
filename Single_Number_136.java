import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Single_Number_136 {
    public int singleNumber(int[] nums) {
        int bitWise = 0;
        for (int num : nums) {
            bitWise ^= num;
        }
        return bitWise;
    }

    @Test
    public void testSingleNumber() {
        int[] exampleOneExpectedResult = { 2, 2, 1 };
        int[] exampleTwoExpectedResult = { 4, 1, 2, 1, 2 };
        int[] exampleThreeExpectedResult = { 1 };

        assertEquals(1, singleNumber(exampleOneExpectedResult));
        assertEquals(4, singleNumber(exampleTwoExpectedResult));
        assertEquals(1, singleNumber(exampleThreeExpectedResult));
    }
}

/*
 * https://leetcode.com/problems/single-number/
 * Explanation
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