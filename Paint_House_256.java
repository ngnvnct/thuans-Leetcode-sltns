import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Paint_House_256 {
    public int paintHouse(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[] dp = new int[3];

        for (int i = 0; i < costs.length; i++) {
            int firstHouse = costs[i][0] + Math.min(dp[1], dp[2]);
            int secondHouse = costs[i][1] + Math.min(dp[0], dp[2]);
            int thirdhouse = costs[i][2] + Math.min(dp[0], dp[1]);
            dp[0] = firstHouse;
            dp[1] = secondHouse;
            dp[2] = thirdhouse;
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }

    public int paintHouse2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
        }
        int n = costs.length - 1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }

    @Test
    public void testPaintHouse() {
        int[][] exampleOne = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        int exampleOneExpectedResult = 10;
        int[][] exampleTwo = { { 7, 6, 2 } };
        int exampleTwoExpectedResult = 2;
        int[][] exampleThree = { { 17, 2, 17 }, { 8, 4, 10 }, { 6, 3, 19 }, { 4, 8, 12 } };
        int exampleThreeExpectedResult = 17;

        assertEquals(exampleOneExpectedResult, paintHouse(exampleOne));
        assertEquals(exampleTwoExpectedResult, paintHouse(exampleTwo));
        assertEquals(exampleThreeExpectedResult, paintHouse(exampleThree));

        assertEquals(exampleOneExpectedResult, paintHouse2(exampleOne));
        assertEquals(exampleTwoExpectedResult, paintHouse2(exampleTwo));
        assertEquals(exampleThreeExpectedResult, paintHouse2(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/paint-house/ LC Premium
 * Exlpanation
 * 
 * DP Appoarch
 * [17,2,17]
 * [16,16,5]
 * [14,3,19]]
 * 
 * 0 1 2
 * 0 17 2 17
 * 1 18 33 7
 * 2 21 10 37
 * First row, we paint 17,2,17
 * Second Row, we paint 16 plus the minimum of the previous row, we choose 2,
 * 18, then if we paint the 2nd house with 16, then the minimum will be 33, and
 * so on
 * At the last row, we take the minimum of the last grid
 * Notice, we only need to care about the previous row, we can just keep a 1-D
 * array, and update it using the previous row information
 * 
 * Time: O(n * 3), O(n)
 * Space: O(n * 3), O(3), O(1)
 */