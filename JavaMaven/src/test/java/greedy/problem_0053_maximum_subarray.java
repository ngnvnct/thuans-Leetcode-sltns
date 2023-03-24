/*
 * https://leetcode.com/problems/maximum-subarray/
 * Explanation:
 * 
 * Using Kadane's Algorithm, we loop through the array once and see if we should
 * make a new sum or adding it to our current sum
 * 
 * The negative don't contribute anything, if the totalSum is less than 0, we make a new sub array
 * If the totalSum is positive, we continue making the subarray. We update maxSubSum at every iteration
 * 
 * Time: O(n)
 * Space: O(1)
 */

package greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_0053_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int maxSubSum = nums[0];
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
            maxSubSum = Math.max(maxSubSum, totalSum);
            if (totalSum < 0) {
                totalSum = 0;
            }
        }
        return maxSubSum;
    }

    @Test
    public void testMaxSubarray() {
        int[] testCase1 = new int[] { -2, 2, 5, -11, 6 };
        int testCase1ExpectedResult = 7;
        int[] testCase2 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int testCase2ExpectedResult = 6;
        int[] testCase3 = new int[] { 1 };
        int testCase3ExpectedResult = 1;
        int[] testCase4 = new int[] { 5, 4, -1, 7, 8 };
        int testCase4ExpectedResult = 23;

        assertEquals(testCase1ExpectedResult, maxSubArray(testCase1));
        assertEquals(testCase2ExpectedResult, maxSubArray(testCase2));
        assertEquals(testCase3ExpectedResult, maxSubArray(testCase3));
        assertEquals(testCase4ExpectedResult, maxSubArray(testCase4));
    }
}
