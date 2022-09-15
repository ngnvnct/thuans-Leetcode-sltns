import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class house_robber_i {
    public int houseRobber(int[] nums) {
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

    public int houseRobberSpace(int[] nums) {
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
    public void testHouseRobber() {
        int[] exampleOne = { 1, 2, 3, 1 };
        int[] exampleTwo = { 2, 7, 9, 3, 1 };
        assertEquals(4, houseRobber(exampleOne));
        assertEquals(12, houseRobber(exampleTwo));
        assertEquals(4, houseRobberSpace(exampleOne));
        assertEquals(12, houseRobberSpace(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/house-robber/
 * Explanation
 * 
 * Bottom up DP Problem. A space optimization is we only need the last 2-steps
 * back value, so we can hold them in 2 variables instead. It is similar to
 * Fibonacci Problem
 * 
 * Time: O(n)
 * Space: O(n) or O(1)
 */