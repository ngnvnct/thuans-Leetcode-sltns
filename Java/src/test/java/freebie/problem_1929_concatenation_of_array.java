/*
 * https://leetcode.com/problems/concatenation-of-array/
 * Explanation:
 * 
 * Method 1: Simlar to the N-th Tribonacci Number Problem
 * https://leetcode.com/problems/n-th-tribonacci-number/
 * We juse use mod to get the correct index.
 * 0 mod 3 = 0, 1 mod 3 = 1, 2 mod 3 = 2
 * 3 mod 3 = 0, 4 mod 3 = 1, 5 mod 3 = 2
 * This method will have O(n) time where n is the length of the result array
 * 
 * Method 2: This method will have O(n) time where n is the length of the input
 * array
 * We loop through the input array, then set current index = current element at
 * input array, then we also set the next set of index (i + nums.length) to be
 * the same
 * 
 * Space: O(n) for output array
 */

package freebie;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class problem_1929_concatenation_of_array {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % nums.length];
        }
        return ans;
    }

    public int[] getConcatenation2(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    @Test
    public void testConcatenation() {
        int[] testCase1 = new int[] { 1, 2, 1 };
        int[] testCase1ExpectedResult = new int[] { 1, 2, 1, 1, 2, 1 };
        int[] testCase2 = new int[] { 1, 3, 2, 1 };
        int[] testCase2ExpectedResult = new int[] { 1, 3, 2, 1, 1, 3, 2, 1 };

        assertArrayEquals(testCase1ExpectedResult, getConcatenation(testCase1));
        assertArrayEquals(testCase2ExpectedResult, getConcatenation(testCase2));

        assertArrayEquals(testCase1ExpectedResult, getConcatenation2(testCase1));
        assertArrayEquals(testCase2ExpectedResult, getConcatenation2(testCase2));
    }
}