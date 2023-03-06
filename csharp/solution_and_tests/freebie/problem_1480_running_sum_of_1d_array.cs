/*
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * Explanation:
 * 
 * There is a solution which use the input array and modify it, not ideal. Can
 * start the loop at 0 or 1 it doesn't matter
 * For solution 2 there is one extra calculation, other than that pretty
 * obvious.
 * 
 * Time: O(n)
 * Space: O(1) if we don't care about output array
 */

using NUnit.Framework;

namespace Running_Sum_of_1d_Array
{
    class Solution
    {
        public static int[] RunningSum(int[] nums)
        {
            int[] runningSum = new int[nums.Length];
            runningSum[0] = nums[0];
            for (int i = 1; i < nums.Length; i++)
            {
                runningSum[i] = runningSum[i - 1] + nums[i];
            }
            return runningSum;
        }

        public static int[] RunningSum2(int[] nums)
        {
            int[] runningSum = new int[nums.Length];
            int totalSum = 0;
            for (int i = 0; i < runningSum.Length; i++)
            {
                totalSum += nums[i];
                runningSum[i] = totalSum;
            }
            return runningSum;
        }
    }

    public class Tests
    {
        [Test]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = new int[] { 1, 3, 6, 10 })]
        [TestCase(new int[] { 1, 1, 1, 1, 1 }, ExpectedResult = new int[] { 1, 2, 3, 4, 5 })]
        [TestCase(new int[] { 3, 1, 2, 10, 1 }, ExpectedResult = new int[] { 3, 4, 6, 16, 17 })]
        public int[] TestRunningSum(int[] nums)
        {
            return Solution.RunningSum(nums);
        }

        [Test]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = new int[] { 1, 3, 6, 10 })]
        [TestCase(new int[] { 1, 1, 1, 1, 1 }, ExpectedResult = new int[] { 1, 2, 3, 4, 5 })]
        [TestCase(new int[] { 3, 1, 2, 10, 1 }, ExpectedResult = new int[] { 3, 4, 6, 16, 17 })]
        public int[] TestRunningSum2(int[] nums)
        {
            return Solution.RunningSum2(nums);
        }
    }
}