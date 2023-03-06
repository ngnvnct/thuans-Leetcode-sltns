/*
 * https://leetcode.com/problems/maximum-subarray/
 * Explanation:
 * 
 * Using Kadane's Algorithm, we loop through the array once and see if we should
 * make a new sum or adding it to our current sum
 * 
 * The negative don't contribute anything, if the totalSum is less than 0, we make a new sub array
 * If the totalSum is positive, we continue making the subarray. We update maxSubSum at every iteration
 * 
 * Time: O(n)
 * Space: O(1)
 */

using System;
using NUnit.Framework;

namespace Maximum_Subarray
{
    class Solution
    {
        public static int MaxSubArray(int[] nums)
        {
            int maxSubSum = nums[0];
            int totalSum = 0;
            foreach(int num in nums)
            {
                totalSum += num;
                maxSubSum = Math.Max(maxSubSum, totalSum);
                if (totalSum < 0)
                {
                    totalSum = 0;
                }
            }
            return maxSubSum;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { -2, 2, 5, -11, 6 }, ExpectedResult = 7)]
        [TestCase(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, ExpectedResult = 6)]
        [TestCase(new int[] { 1 }, ExpectedResult = 1)]
        [TestCase(new int[] { 5, 4, -1, 7, 8 }, ExpectedResult = 23)]
        public int TestMaxSubArray(int[] nums)
        {
            return Solution.MaxSubArray(nums);
        }
    }
}
