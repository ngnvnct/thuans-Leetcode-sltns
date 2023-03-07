/*
 * https://leetcode.com/problems/richest-customer-wealth/
 * Explanation:
 * 
 * Straight forward problem, loop through each account then calculate the sum,
 * wealth will be the max of current wealth or the new bank account sum.
 * 
 * Time: O(m * n)
 * Space: O(1)
 */

using System;
using System.Linq;
using NUnit.Framework;

namespace Richest_Customer_Wealth
{
    class Solution
    {
        public static int MaximumWealth(int[][] accounts)
        {
            int richestCustomerWealth = 0;
            foreach (int[] account in accounts)
            {
                richestCustomerWealth = Math.Max(richestCustomerWealth, account.Sum());
            }
            return richestCustomerWealth;
        }
    }

    class Tests
    {
        [Test]
        public void TestMaximumWealth()
        {
            int[][] testCase1 = new int[][] { new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 } };
            int testCase1ExpectedResult = 6;
            int[][] testCase2 = new int[][] { new int[] { 1, 5 }, new int[] { 7, 3 }, new int[] { 3, 5 } };
            int testCase2ExpectedResult = 10;
            int[][] testCase3 = new int[][] { new int[] { 2, 8, 7 }, new int[] { 7, 1, 3 }, new int[] { 1, 9, 5 } };
            int testCase3ExpectedResult = 17;

            Assert.AreEqual(testCase1ExpectedResult, Solution.MaximumWealth(testCase1));
            Assert.AreEqual(testCase2ExpectedResult, Solution.MaximumWealth(testCase2));
            Assert.AreEqual(testCase3ExpectedResult, Solution.MaximumWealth(testCase3));
        }
    }
}