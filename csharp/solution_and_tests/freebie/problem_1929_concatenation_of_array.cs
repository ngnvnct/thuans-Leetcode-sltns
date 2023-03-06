/*
 * https://leetcode.com/problems/concatenation-of-array/
 * Explanation:
 * 
 * Method 1: Simlar to the N-th Tribonacci Number Problem
 * https://leetcode.com/problems/n-th-tribonacci-number/
 * We juse use mod to get the correct index.
 * 0 mod 3 = 0, 1 mod 3 = 1, 2 mod 3 = 2
 * 3 mod 3 = 0, 4 mod 3 = 1, 5 mod 3 = 2
 * This method will have O(n) time where n is the length of the result array
 * 
 * Method 2: This method will have O(n) time where n is the length of the input
 * array
 * We loop through the input array, then set current index = current element at
 * input array, then we also set the next set of index (i + nums.length) to be
 * the same
 * 
 * Space: O(n) for output array
 */
using NUnit.Framework;

namespace Concatenation_of_Array
{
    class Solution
    {
        public static int[] GetConcatenation(int[] nums)
        {
            int[] ans = new int[nums.Length * 2];
            for (int i = 0; i < ans.Length; i++)
            {
                ans[i] = nums[i % nums.Length];
            }
            return ans;
        }

        public static int[] GetConcatenation2(int[] nums)
        {
            int[] ans = new int[nums.Length * 2];
            for (int i = 0; i < nums.Length; i++)
            {
                ans[i] = ans[i + nums.Length] = nums[i];
            }
            return ans;
        }
    }

    public class Tests
    {
        [Test]
        [TestCase(new int[] { 1, 2, 1 }, ExpectedResult = new int[] { 1, 2, 1, 1, 2, 1 })]
        [TestCase(new int[] { 1, 3, 2, 1 }, ExpectedResult = new int[] { 1, 3, 2, 1, 1, 3, 2, 1 })]
        public int[] TestGetConcatenation(int[] nums)
        {
            return Solution.GetConcatenation(nums);
        }

        [Test]
        [TestCase(new int[] { 1, 2, 1 }, ExpectedResult = new int[] { 1, 2, 1, 1, 2, 1 })]
        [TestCase(new int[] { 1, 3, 2, 1 }, ExpectedResult = new int[] { 1, 3, 2, 1, 1, 3, 2, 1 })]
        public int[] TestGetConcatenation2(int[] nums)
        {
            return Solution.GetConcatenation2(nums);
        }
    }
}