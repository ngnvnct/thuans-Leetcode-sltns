/*
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * Explanation:
 * 
 * There is a solution which use the input array and modify it, not ideal. Can
 * start the loop at 0 or 1 it doesn't matter
 * For solution 1 there is one extra calculation, other than that pretty
 * obvious.
 * 
 * Time: O(n)
 * Space: O(1) if we don't care about output array, O(n) otherwise
 */

package freebie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class problem_1480_running_sum_of_1d_array {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            runningSum[i] = totalSum;
        }
        return runningSum;
    }

    public int[] runningSum2(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] += runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

    @Test
    public void testRunningSum() {
        int[] testCase1 = new int[] { 1, 2, 3, 4 };
        int[] testCase1ExpectedResult = new int[] { 1, 3, 6, 10 };
        int[] testCase2 = new int[] { 1, 1, 1, 1, 1 };
        int[] testCase2ExpectedResult = new int[] { 1, 2, 3, 4, 5 };
        int[] testCase3 = new int[] { 3, 1, 2, 10, 1 };
        int[] testCase3ExpectedResult = new int[] { 3, 4, 6, 16, 17 };

        assertArrayEquals(testCase1ExpectedResult, runningSum(testCase1));
        assertArrayEquals(testCase2ExpectedResult, runningSum(testCase2));
        assertArrayEquals(testCase2ExpectedResult, runningSum(testCase2));

        assertArrayEquals(testCase1ExpectedResult, runningSum(testCase1));
        assertArrayEquals(testCase2ExpectedResult, runningSum(testCase2));
        assertArrayEquals(testCase3ExpectedResult, runningSum(testCase3));
    }
}