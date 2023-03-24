import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class House_Robber_II_213 {
    public int houseRobber(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helperHouseRobberI(nums, 0, n - 2), helperHouseRobberI(nums, 1, n - 1));
        // return Math.max(helperHouseRobberISpace(nums, 0, n-2),
        // helperHouseRobberI(nums, 1, n-1));
    }

    public int helperHouseRobberI(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public int helperHouseRobberISpace(int[] nums, int start, int end) {
        int prevRob = 0;
        int prevNotRob = 0;
        int rob = 0;
        int notRob = 0;
        for (int i = start; i <= end; i++) {
            rob = prevNotRob + nums[i];
            notRob = Math.max(prevRob, prevNotRob);
            prevNotRob = notRob;
            prevRob = rob;
        }
        return Math.max(rob, notRob);
    }

    @Test
    public void testHouseRobber() {
        int[] testCase1 = { 2, 3, 2 };
        int[] testCase2 = { 1, 2, 3, 1 };
        assertEquals(3, houseRobber(testCase1));
        assertEquals(4, houseRobber(testCase2));
    }
}

/*
 * https://leetcode.com/problems/house-robber-ii/
 * Explanation
 * 
 * Bottom up DP Problem. It is just House Robber 1 and we call it twice, 1 going
 * from 0 to n-2, and the other 1 to n-2
 * 
 * Time: O(n)
 * Space: O(n) or O(1)
 */