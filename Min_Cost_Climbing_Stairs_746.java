import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Min_Cost_Climbing_Stairs_746 {

    public int minstCostClimbingStairsRecursion(int[] cost) {
        return Math.min(minCost(cost,  cost.length-1), minCost(cost, cost.length-2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return cost[n];
        }
        return cost[n] + Math.min(minCost(cost,n-1), minCost(cost, n-2));
    }

    public int minCostClimbingStairsDP(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int minCostOneStep = cost[0];
        int minCostTwoSteps = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int payToll = cost[i] + Math.min(minCostOneStep, minCostTwoSteps);
            minCostOneStep = minCostTwoSteps;
            minCostTwoSteps = payToll;
        }
        return Math.min(minCostOneStep, minCostTwoSteps);
    }

    @Test
    public void testClimbingStairs() {
        int[] exampleOne = new int[] { 10, 15, 20 };
        assertEquals(15, minCostClimbingStairs(exampleOne));
        assertEquals(15, minCostClimbingStairsDP(exampleOne));
        assertEquals(15, minstCostClimbingStairsRecursion(exampleOne));

        int[] exampleTwo = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        assertEquals(6, minCostClimbingStairs(exampleTwo));
        assertEquals(6, minCostClimbingStairsDP(exampleTwo));
        assertEquals(6, minstCostClimbingStairsRecursion(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * Dynamic Programming Bottom-Up approach optimize space. The naive way is have
 * a DP array and build up the sub-problems into a bigger problem. You can
 * optimize space by only storing the smaller value
 * 
 * Time: O(n)
 * Space: O(1)
 */