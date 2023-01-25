/*
 * https://leetcode.com/problems/paint-house/ LC Premium
 * Explanation:
 * 
 * DP Appoarch
 * [17,2,17]
 * [16,16,5]
 * [14,3,19]
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
 * Space: O(3) ~ O(1)
 */

using System;
using NUnit.Framework;

namespace Paint_House
{
    class Solution
    {
        public int MinCost(int[][] costs)
        {
            int[] previousRow = new int[3];
            for (int i = 0; i < costs.Length; i++)
            {
                int currentRowHouse0 = costs[i][0] + Math.Min(previousRow[1], previousRow[2]);
                int currentRowHouse1 = costs[i][1] + Math.Min(previousRow[0], previousRow[2]);
                int currentRowHouse2 = costs[i][2] + Math.Min(previousRow[0], previousRow[1]);
                previousRow[0] = currentRowHouse0;
                previousRow[1] = currentRowHouse1;
                previousRow[2] = currentRowHouse2;
            }
            return Math.Min(Math.Min(previousRow[0], previousRow[1]), previousRow[2]);
        }
    }

    class Tests
    {
        Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        public void TestMinCost()
        {
            int[][] testCase1 = new int[][] {new int[] { 17, 2, 17 }, new int[] { 16, 16, 5 }, new int[] { 14, 3, 19 } };
            int testCase1ExpectedResult = 10;
            int[][] testCase2 = new int[][] { new int[] { 7, 6, 2 } };
            int testCase2ExpectedResult = 2;
            int[][] testCase3 = new int[][] { new int[] { 17, 2, 17 }, new int[] { 8, 4, 10 }, new int[] { 6, 3, 19 }, new int[] { 4, 8, 12 } };
            int testCase3ExpectedResult = 17;

            Assert.AreEqual(testCase1ExpectedResult, sol.MinCost(testCase1));
            Assert.AreEqual(testCase2ExpectedResult, sol.MinCost(testCase2));
            Assert.AreEqual(testCase3ExpectedResult, sol.MinCost(testCase3));
        }
    }
}
