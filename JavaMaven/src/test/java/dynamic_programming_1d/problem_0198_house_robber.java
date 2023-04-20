/*
 * https://leetcode.com/problems/house-robber/
 * Explanation:
 * 
 * Bottom up DP Problem. A space optimization is we only need the last 2-steps
 * back value, so we can hold them in 2 variables instead. It is similar to
 * Fibonacci Problem
 * 
 * Time: O(n)
 * Space: O(n) or O(1)
 */

package dynamic_programming_1d;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class problem_0198_house_robber {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int robSpace(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int robPrevOne = 0;
        int robPrevTwo = 0;
        for (int rob : nums) {
            int temp = robPrevOne;
            robPrevOne = Math.max(robPrevTwo + rob, robPrevOne);
            robPrevTwo = temp;
        }
        return robPrevOne;
    }

    @Test
    public void testRob() {
        int[] testCase1 = { 1, 2, 3, 1 };
        int[] testCase2 = { 2, 7, 9, 3, 1 };
        int[] testCase3 = { 1, 2, 3 };
        int[] testCase4 = { 2, 1, 1, 2 };
        int[] testCase5 = { 1, 1, 1, 1, 1, 100 };
        int[] testCase6 = { 4, 1, 2, 7, 5, 3, 1 };
        
        int testCase1ExpectedResult = 4;
        int testCase2ExpectedResult = 12;
        int testCase3ExpectedResult = 4;
        int testCase4ExpectedResult = 4;
        int testCase5ExpectedResult = 102;
        int testCase6ExpectedResult = 14;
        
        assertEquals(testCase1ExpectedResult, rob(testCase1));
        assertEquals(testCase2ExpectedResult, rob(testCase2));
        assertEquals(testCase3ExpectedResult, rob(testCase3));
        assertEquals(testCase4ExpectedResult, rob(testCase4));
        assertEquals(testCase5ExpectedResult, rob(testCase5));
        assertEquals(testCase6ExpectedResult, rob(testCase6));
        
        assertEquals(testCase1ExpectedResult, robSpace(testCase1));
        assertEquals(testCase2ExpectedResult, robSpace(testCase2));
        assertEquals(testCase3ExpectedResult, robSpace(testCase3));
        assertEquals(testCase4ExpectedResult, robSpace(testCase4));
        assertEquals(testCase5ExpectedResult, robSpace(testCase5));
        assertEquals(testCase6ExpectedResult, robSpace(testCase6));
    }
    
}