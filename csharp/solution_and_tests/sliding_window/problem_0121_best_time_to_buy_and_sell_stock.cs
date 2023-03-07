/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Explanation:
 * 
 * Using Kadane's Algorithm to keep track of the largest sum array to get the
 * most profit.
 * 
 * Time: O(n)
 * Space: O(1)
 */

using System;
using NUnit.Framework;

namespace Best_Time_to_Buy_and_Sell_Stock
{
    class Solution
    {
        public static int MaxProfit(int[] prices)
        {
            if (prices == null)
            {
                return 0;
            }
            int minBuy = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < prices.Length; i++)
            {
                minBuy = Math.Min(prices[i], minBuy);
                maxProfit = Math.Max(maxProfit, prices[i] - minBuy);
            }
            return maxProfit;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { 7, 1, 5, 3, 6, 4 }, ExpectedResult = 5)]
        [TestCase(new int[] { 7, 6, 4, 3, 1 }, ExpectedResult = 0)]
        public int TestMaxProfit(int[] prices)
        {
            return Solution.MaxProfit(prices);
        }
    }
}
