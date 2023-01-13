/*
 * https://leetcode.com/problems/paint-house/ LC Premium
 * Explanation:
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

package Java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0256_paint_house {
    public int paintHouse(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[] previousRow = new int[3];

        for (int i = 0; i < costs.length; i++) {
            int currentRowHouse0 = costs[i][0] + Math.min(previousRow[1], previousRow[2]);
            int currentRowHouse1 = costs[i][1] + Math.min(previousRow[0], previousRow[2]);
            int currentRowHouse2 = costs[i][2] + Math.min(previousRow[0], previousRow[1]);
            previousRow[0] = currentRowHouse0;
            previousRow[1] = currentRowHouse1;
            previousRow[2] = currentRowHouse2;
        }
        return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
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
        int[][] testCase1 = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        int testCase1ExpectedResult = 10;
        int[][] testCase2 = { { 7, 6, 2 } };
        int testCase2ExpectedResult = 2;
        int[][] testCase3 = { { 17, 2, 17 }, { 8, 4, 10 }, { 6, 3, 19 }, { 4, 8, 12 } };
        int testCase3ExpectedResult = 17;

        assertEquals(testCase1ExpectedResult, paintHouse(testCase1));
        assertEquals(testCase2ExpectedResult, paintHouse(testCase2));
        assertEquals(testCase3ExpectedResult, paintHouse(testCase3));

        assertEquals(testCase1ExpectedResult, paintHouse2(testCase1));
        assertEquals(testCase2ExpectedResult, paintHouse2(testCase2));
        assertEquals(testCase3ExpectedResult, paintHouse2(testCase3));
    }
}