import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Coin_Change_322 {
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
        assertEquals(3, coinChange(new int[] {1,2,5}, 11));
        assertEquals(-1, coinChange(new int[] {2}, 3));
        assertEquals(0, coinChange(new int[] {1}, 0));
    }
}

/*
 * https://leetcode.com/problems/coin-change/
 * Explanation
 * 
 * Bottom-Up Dynamic Programming apporach. Build up an array of DP and solve the
 * sub-problem then build up the DP Array.
 * 
 * Time: O(n * m) where n is the amount and m is the array of coins
 * Space: O(n) where n is the amount;
 */