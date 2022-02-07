import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class coin_change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                //System.out.println("dp[" + i +"] is " + dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void testCoinChange() {
        int[] exampleOne = new int[] {1,2,5};
        assertEquals(3, coinChange(exampleOne, 11));

        int[] exampleTwo = new int[] {2};
        assertEquals(-1, coinChange(exampleTwo, 3));

        int[] exampleThree = new int[] {1};
        assertEquals(0, coinChange(exampleThree, 0));
    }
}



/*
Bottom-Up Dynamic Programming apporach. Build up an array of DP and solve the sub-problem then build up the DP Array.

Time: O(n * m) where n is the amount and m is the array of coins
Space: O(n) where n is the amount;

*/