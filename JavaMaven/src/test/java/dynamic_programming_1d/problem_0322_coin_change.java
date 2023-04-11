/*
 * https://leetcode.com/problems/coin-change/
 * Explanation:
 * 
 * Bottom-Up Dynamic Programming apporach. Build up an array of DP and solve the
 * sub-problem then build up the DP Array.
 * 
 * Time: O(n * m) where n is the amount and m is the array of coins
 * Space: O(n) where n is the amount;
 */

package dynamic_programming_1d;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class problem_0322_coin_change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                // System.out.println("dp[" + i +"] is " + dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void testCoinChange() {
        int[] testCase1 = { 1, 2, 5 };
        int testCase1ExpectedResult = 3;
        int[] testCase2 = { 2 };
        int testCase2ExpectedResult = -1;
        int[] testCase3 = { 1 };
        int testCase3ExpectedResult = 0;
        int[] testCase4 = { 1, 4, 5 };
        int testCase4ExpectedResult = 4;
        int[] testCase5 = { 2, 5, 10 };
        int testCase5ExpectedResult = 6;

        assertEquals(testCase1ExpectedResult, coinChange(testCase1, 11));
        assertEquals(testCase2ExpectedResult, coinChange(testCase2, 3));
        assertEquals(testCase3ExpectedResult, coinChange(testCase3, 0));
        assertEquals(testCase4ExpectedResult, coinChange(testCase4, 17));
        assertEquals(testCase5ExpectedResult, coinChange(testCase5, 23));
    }
}